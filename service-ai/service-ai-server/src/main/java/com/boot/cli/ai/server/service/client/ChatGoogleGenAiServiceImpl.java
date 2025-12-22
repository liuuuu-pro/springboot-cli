package com.boot.cli.ai.server.service.client;

import com.boot.cli.ai.model.vo.ChatRespSimpleVO;
import com.boot.cli.ai.model.vo.UsageVO;
import com.boot.cli.ai.server.domain.request.ai.ChatRequest;
import com.boot.cli.ai.server.service.AiChatBaseService;
import com.google.genai.Client;
import com.google.genai.ResponseStream;
import com.google.genai.types.GenerateContentResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service("google")
public class ChatGoogleGenAiServiceImpl extends AbstractChatService implements AiChatBaseService {

    @Autowired
    private Client googleGenAiClient;

    @Override
    public ChatRespSimpleVO chatCompletions(ChatRequest request) {
        UsageVO usage = UsageVO.of();
        StringBuilder responseText = new StringBuilder();
        try (ResponseStream<GenerateContentResponse> responseStream =
                     googleGenAiClient.models.generateContentStream(
                             request.modelName(),
                             buildContents(request.messages()),
                             googleContentConfig(request))) {
            for (GenerateContentResponse res : responseStream) {
                String text = res.text();
                if (Objects.nonNull(text)) {
                    responseText.append(text);
                }
                usage = build(res.usageMetadata());
            }
        }
        return build(responseText.toString(), usage);
    }

}
