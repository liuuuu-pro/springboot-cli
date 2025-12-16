package com.boot.cli.ai.server.service.impl;

import com.boot.cli.ai.model.vo.ChatRespSimpleVO;
import com.boot.cli.ai.server.domain.request.ai.ChatRequest;
import com.boot.cli.ai.server.service.AiChatBaseService;
import com.boot.cli.ai.server.service.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private Map<String, AiChatBaseService> chatClientService;

    @Override
    public ChatRespSimpleVO chat(ChatRequest request) {
        AiChatBaseService clientService = chatClientService.get(request.serviceName());
        return clientService.chatCompletions(request);
    }

}
