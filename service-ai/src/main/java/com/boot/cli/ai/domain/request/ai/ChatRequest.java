package com.boot.cli.ai.domain.request.ai;

import com.boot.cli.ai.domain.bo.spring.MessageBO;
import com.boot.cli.common.core.exception.ServiceException;
import com.google.genai.types.GenerateContentConfig;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.MessageType;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.ResponseFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @param model 模型名称规则：模型名称前带上service名称：
 * doubao/ep-****
 * google/gemini-2.5-flash
 */
public record ChatRequest(@NotEmpty String model,
                          @NotEmpty List<MessageBO> messages,
                          ResponseFormat responseFormat,
                          Double temperature,
                          String reasoningEffort,
                          String fileSearchStoreName) {

    public OpenAiChatOptions openaiOptions() {
        OpenAiChatOptions options = new OpenAiChatOptions();
        options.setModel(modelName());
        options.setResponseFormat(responseFormat);
        options.setTemperature(temperature);
        options.setReasoningEffort(reasoningEffort);
        return options;
    }

    public GenerateContentConfig googleContentConfig() {
        // todo
        return GenerateContentConfig.builder().build();
    }

    public List<Message> openaiMessages() {
        List<Message> openaiMessages = new ArrayList<>();
        messages.forEach(mes -> {
            Message message;
            if (Objects.equals(mes.role(), MessageType.USER.getValue())) {
                message = new UserMessage(mes.content());
            } else if (Objects.equals(mes.role(), MessageType.SYSTEM.getValue())) {
                message = new SystemMessage(mes.content());
            } else {
                throw new ServiceException("不支持的对话类型");
            }
            openaiMessages.add(message);
        });
        return openaiMessages;
    }

    public String modelName() {
        return model.split("/")[1];
    }

    public String serviceName() {
        return model.split("/")[0];
    }

}
