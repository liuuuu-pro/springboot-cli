package com.boot.cli.ai.server.service;

import com.boot.cli.ai.model.vo.ChatRespSimpleVO;
import com.boot.cli.ai.server.domain.request.ai.ChatRequest;

public interface ChatService {

    ChatRespSimpleVO chat(ChatRequest request);

}
