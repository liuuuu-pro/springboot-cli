package com.boot.cli.ai.config;

import com.boot.cli.ai.config.properties.ChatClientConfigProperties;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ChatClientConfigProperties.class)
public class ChatClientConfig {

    @Autowired
    private ChatClientConfigProperties properties;

    @Bean
    public ChatClient chatClient() {
        OpenAiApi api = OpenAiApi.builder()
                .baseUrl(properties.getBaseUrl())
                .completionsPath(properties.getCompletionsPath())
                .apiKey(properties.getSimpleApiKey())
                .build();
        OpenAiChatModel openai = OpenAiChatModel.builder().openAiApi(api).build();
        return ChatClient.builder(openai).build();
    }

}
