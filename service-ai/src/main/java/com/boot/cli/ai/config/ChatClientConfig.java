package com.boot.cli.ai.config;

import cn.hutool.core.collection.CollUtil;
import com.boot.cli.ai.config.properties.GoogleGenAiProperties;
import com.boot.cli.ai.config.properties.OpenaiCompatibleProperties;
import com.boot.cli.ai.domain.bo.OpenaiServiceBO;
import com.google.genai.Client;
import com.google.genai.types.HttpOptions;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableConfigurationProperties({OpenaiCompatibleProperties.class, GoogleGenAiProperties.class})
public class ChatClientConfig {

    @Autowired
    private OpenaiCompatibleProperties openaiCompatible;
    @Autowired
    private GoogleGenAiProperties googleProperties;

    @Bean
    public Map<String, ChatClient> openaiCompatibleClients() {
        Map<String, OpenaiServiceBO> services = openaiCompatible.services();
        if (CollUtil.isEmpty(services)) {
            return Collections.emptyMap();
        }
        Map<String, ChatClient> clients = new HashMap<>(services.size());
        services.forEach((serviceName, item) -> {

            OpenAiApi api = OpenAiApi.builder()
                    .baseUrl(item.baseUrl())
                    .completionsPath(item.completionsPath())
                    .apiKey(item.simpleApiKey())
                    .build();
            OpenAiChatModel openai = OpenAiChatModel.builder().openAiApi(api).build();
            ChatClient client = ChatClient.builder(openai).build();

            clients.put(serviceName, client);

        });
        return clients;
    }

    @Bean
    public Client googleGenAiClient() {
        return Client.builder().httpOptions(HttpOptions.builder()
                        .build())
                .apiKey(googleProperties.apiKey())
                .build();
    }

}
