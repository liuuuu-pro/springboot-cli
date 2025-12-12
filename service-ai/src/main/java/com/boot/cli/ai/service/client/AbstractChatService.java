package com.boot.cli.ai.service.client;

import com.alibaba.fastjson.JSONObject;
import com.boot.cli.ai.domain.bo.spring.RespBO;
import com.boot.cli.ai.domain.request.ai.ChatRequest;
import com.boot.cli.ai.domain.vo.ai.ChatRespSimpleVO;
import com.boot.cli.ai.service.AiChatBaseService;
import com.boot.cli.common.core.exception.ServiceException;
import com.boot.cli.common.core.util.Json;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class AbstractChatService implements AiChatBaseService {

    @Autowired
    protected Map<String, ChatClient> openaiCompatibleClients;

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
        return ChatRespSimpleVO.of(contents);
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
