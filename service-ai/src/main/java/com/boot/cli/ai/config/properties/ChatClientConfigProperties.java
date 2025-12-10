package com.boot.cli.ai.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("cli.ai.model")
public class ChatClientConfigProperties {

    private String baseUrl;
    private String completionsPath;
    private String simpleApiKey;
    private String model;

}
