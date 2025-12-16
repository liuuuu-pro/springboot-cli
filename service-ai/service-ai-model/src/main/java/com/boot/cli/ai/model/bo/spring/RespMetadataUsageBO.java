package com.boot.cli.ai.model.bo.spring;

import lombok.Data;

@Data
public class RespMetadataUsageBO {

    private Long promptTokens;
    private Long completionTokens;
    private Long totalTokens;

}
