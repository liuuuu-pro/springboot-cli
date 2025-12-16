package com.boot.cli.ai.server.service.client;

import com.boot.cli.ai.model.vo.ChatRespSimpleVO;
import com.boot.cli.ai.server.domain.request.ai.ChatRequest;
import com.boot.cli.ai.server.service.AiChatBaseService;
import com.google.genai.Client;
import com.google.genai.ResponseStream;
import com.google.genai.types.GenerateContentResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service("google")
public class ChatGoogleGenAiServiceImpl extends AbstractChatService implements AiChatBaseService {

    @Autowired
    private Client googleGenAiClient;

    @Override
    public ChatRespSimpleVO chatCompletions(ChatRequest request) {

        ResponseStream<GenerateContentResponse> responseStream =
                googleGenAiClient.models.generateContentStream(
                        request.modelName(), "Write a story about a magic backpack.", request.googleContentConfig());

        for (GenerateContentResponse res : responseStream) {
            System.out.print(res.text());
        }

        // To save resources and avoid connection leaks, it is recommended to close the response
        // stream after consumption (or using try block to get the response stream).
        responseStream.close();
        // todo

        return null;
    }

}
