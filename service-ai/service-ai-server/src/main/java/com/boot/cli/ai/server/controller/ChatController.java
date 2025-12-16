package com.boot.cli.ai.server.controller;

import com.boot.cli.ai.model.vo.ChatRespSimpleVO;
import com.boot.cli.ai.server.domain.request.ai.ChatRequest;
import com.boot.cli.ai.server.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
    public ChatRespSimpleVO chat(@RequestBody @Validated ChatRequest request) {
        return chatService.chat(request);
    }

}
