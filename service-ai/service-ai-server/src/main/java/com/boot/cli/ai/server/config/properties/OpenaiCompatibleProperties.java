package com.boot.cli.ai.server.config.properties;

import com.boot.cli.ai.server.domain.bo.OpenaiServiceBO;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties("cli.ai.model.openai")
public record OpenaiCompatibleProperties(Map<String, OpenaiServiceBO> services) {

}
