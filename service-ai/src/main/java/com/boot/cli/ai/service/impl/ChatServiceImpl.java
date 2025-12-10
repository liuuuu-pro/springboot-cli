package com.boot.cli.ai.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.boot.cli.ai.config.properties.ChatClientConfigProperties;
import com.boot.cli.ai.domain.bo.ai.MessageBO;
import com.boot.cli.ai.domain.bo.ai.RespBO;
import com.boot.cli.ai.domain.vo.ai.ChatRespSimpleVO;
import com.boot.cli.ai.service.ChatService;
import com.boot.cli.common.core.exception.ServiceException;
import com.boot.cli.common.core.util.Json;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.MessageType;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatClient chatClient;
    @Autowired
    private ChatClientConfigProperties properties;

    @Override
    public ChatRespSimpleVO chat(OpenAiChatOptions options, List<MessageBO> messages) {
        if (StrUtil.isEmpty(options.getModel())) {
            options.setModel(properties.getModel());
        }
        List<RespBO> contents = chatClient.prompt()
                .messages(of(messages))
                .options(options)
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
        return ChatRespSimpleVO.of(contents);
    }

    private List<Message> of(List<MessageBO> reqMessages) {
        List<Message> messages = new ArrayList<>();
        reqMessages.forEach(mes -> {
            Message message;
            if (Objects.equals(mes.role(), MessageType.USER.getValue())) {
                message = new UserMessage(mes.content());
            } else if (Objects.equals(mes.role(), MessageType.SYSTEM.getValue())) {
                message = new SystemMessage(mes.content());
            } else {
                throw new ServiceException("不支持的对话类型");
            }
            messages.add(message);
        });
        return messages;
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

}
