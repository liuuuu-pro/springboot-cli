package com.boot.cli.ai.server.service.client;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson2.JSONObject;
import com.boot.cli.ai.model.vo.ChatRespSimpleVO;
import com.boot.cli.ai.model.vo.UsageVO;
import com.boot.cli.ai.server.domain.bo.spring.MessageBO;
import com.boot.cli.ai.server.domain.bo.spring.RespBO;
import com.boot.cli.ai.server.domain.bo.spring.RespMetadataUsageBO;
import com.boot.cli.ai.server.domain.request.ai.ChatRequest;
import com.boot.cli.ai.server.service.AiChatBaseService;
import com.boot.cli.ai.server.service.mapper.GoogleAiSchemaMapper;
import com.boot.cli.common.core.constant.ComConstants;
import com.boot.cli.common.core.exception.ServiceException;
import com.boot.cli.common.core.util.CollUtils;
import com.boot.cli.common.core.util.Json;
import com.boot.cli.common.core.util.NumUtils;
import com.google.genai.types.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.api.ResponseFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class AbstractChatService implements AiChatBaseService {

    @Autowired
    protected Map<String, ChatClient> openaiCompatibleClients;
    @Autowired
    protected GoogleAiSchemaMapper googleAiSchemaMapper;

    @Override
    public ChatRespSimpleVO chatCompletions(ChatRequest request) {
        ChatClient chatClient = openaiCompatibleClients.get(request.serviceName());
        List<RespBO> contents = chatClient.prompt()
                .messages(request.openaiMessages())
                .options(request.openaiOptions())
                .stream()
                .chatResponse()
                .doOnError(throwable -> {
                    String errorInfo = parseError(throwable);
                    throw new ServiceException(errorInfo);
                })
                .map(response -> {
                    String event = Json.to(response);
                    return Json.from(event, RespBO.class);
                })
                .collectList()
                .block();
        return build(contents);
    }

    private String parseError(Throwable throwable) {
        if (throwable instanceof WebClientResponseException exception) {
            String body = exception.getResponseBodyAsString();
            try {
                JSONObject response = Json.parseObject(body);
                if (response.containsKey("error")) {
                    JSONObject error = response.getJSONObject("error");
                    return error.toString();
                }
                return body;
            } catch (Exception e) {
                return body;
            }
        }
        return throwable.getMessage();
    }

    public GenerateContentConfig googleContentConfig(ChatRequest request) {
        MessageBO systemMessage = getSystemMessage(request.messages());
        GenerateContentConfig.Builder builder = GenerateContentConfig.builder();
        if (Objects.nonNull(systemMessage)) {
            builder.systemInstruction(Content.fromParts(Part.fromText(systemMessage.content())));
        }
        if (Objects.nonNull(request.temperature())) {
            builder.temperature(request.temperature().floatValue());
        }
        if (Objects.nonNull(request.responseFormat())) {
            builder.responseMimeType(ComConstants.GOOGLE_JSON);
            if (Objects.equals(request.responseFormat().getType(), ResponseFormat.Type.JSON_SCHEMA)) {
                builder.responseSchema(Schema.fromJson(googleAiSchemaMapper.schemaToString(request.responseFormat().getJsonSchema().getSchema())));
            }
        }
        return builder.build();
    }

    public List<Content> buildContents(List<MessageBO> messages) {
        var userList = CollUtils.filter(i -> !Objects.equals(i.role(), ComConstants.AI_ROLE_SYS), messages);
        return CollUtils.collect(i -> Content.fromParts(Part.fromText(i.content())), userList);
    }

    private MessageBO getSystemMessage(List<MessageBO> messages) {
        var systemList = CollUtils.filter(i -> Objects.equals(i.role(), ComConstants.AI_ROLE_SYS), messages);
        return CollUtil.getFirst(systemList);
    }

    protected static UsageVO build(RespMetadataUsageBO usage) {
        return new UsageVO(usage.getPromptTokens(), usage.getCompletionTokens(), usage.getTotalTokens());
    }

    protected static UsageVO build(Optional<GenerateContentResponseUsageMetadata> usageMetadata) {
        GenerateContentResponseUsageMetadata usage = usageMetadata.orElse(null);
        if (Objects.isNull(usage)) {
            return UsageVO.of();
        }
        return new UsageVO(NumUtils.getLong2(usage.promptTokenCount()),
                NumUtils.getLong2(usage.candidatesTokenCount())
                + NumUtils.getLong2(usage.thoughtsTokenCount())
                + NumUtils.getLong2(usage.toolUsePromptTokenCount()),
                NumUtils.getLong2(usage.totalTokenCount()));
    }

    protected static ChatRespSimpleVO build(List<RespBO> contents) {
        if (CollUtil.isEmpty(contents)) {
            return ChatRespSimpleVO.of();
        } else {
            StringBuilder message = new StringBuilder();
            contents.forEach(content -> {
                if (Objects.nonNull(content)) {
                    String contentText = content.getText();
                    message.append(contentText);
                }
            });
            return new ChatRespSimpleVO(message.toString(), build(CollUtil.getLast(contents).getUsage()));
        }
    }

    protected static ChatRespSimpleVO build(String text, UsageVO usage) {
        return new ChatRespSimpleVO(text, usage);
    }

}
