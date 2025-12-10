package com.boot.cli.ai.service;

import com.boot.cli.ai.domain.bo.ai.MessageBO;
import com.boot.cli.ai.domain.vo.ai.ChatRespSimpleVO;
import org.springframework.ai.openai.OpenAiChatOptions;

import java.util.List;

public interface ChatService {

    ChatRespSimpleVO chat(OpenAiChatOptions options, List<MessageBO> messages);

}
