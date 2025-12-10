package com.boot.cli.ai.domain.request.ai;

import com.boot.cli.ai.domain.bo.ai.MessageBO;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.ResponseFormat;

import java.util.List;

public record ChatRequest(String model, List<MessageBO> messages,
                          ResponseFormat responseFormat,
                          Double temperature,
                          String reasoningEffort) {

    public OpenAiChatOptions build() {
        OpenAiChatOptions options = new OpenAiChatOptions();
        options.setModel(model);
        options.setResponseFormat(responseFormat);
        options.setTemperature(temperature);
        options.setReasoningEffort(reasoningEffort);
        return options;
    }

}
