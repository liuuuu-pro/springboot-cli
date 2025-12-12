package com.boot.cli.ai.service;

import com.boot.cli.ai.domain.request.ai.ChatRequest;
import com.boot.cli.ai.domain.vo.ai.ChatRespSimpleVO;

public interface AiChatBaseService {

    ChatRespSimpleVO chatCompletions(ChatRequest request);

}
