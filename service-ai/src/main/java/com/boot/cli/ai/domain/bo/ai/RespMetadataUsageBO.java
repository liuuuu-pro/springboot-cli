package com.boot.cli.ai.domain.bo.ai;

import lombok.Data;

@Data
public class RespMetadataUsageBO {

    private Long promptTokens;
    private Long completionTokens;
    private Long totalTokens;

}
