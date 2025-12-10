package com.boot.cli.ai.controller;

import com.boot.cli.ai.domain.request.ai.ChatRequest;
import com.boot.cli.ai.domain.vo.ai.ChatRespSimpleVO;
import com.boot.cli.ai.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/chat")
    public ChatRespSimpleVO chat(@RequestBody ChatRequest request) {
        return chatService.chat(request.build(), request.messages());
    }

}
