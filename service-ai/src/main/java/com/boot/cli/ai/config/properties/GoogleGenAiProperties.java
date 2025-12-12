package com.boot.cli.ai.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("cli.ai.model.google")
public record GoogleGenAiProperties(String apiKey, String fileSearchStoreDisplayName) {

}
