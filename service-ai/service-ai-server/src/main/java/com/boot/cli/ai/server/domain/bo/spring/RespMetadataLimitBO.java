package com.boot.cli.ai.server.domain.bo.spring;

import lombok.Data;

@Data
public class RespMetadataLimitBO {

    private Long requestsLimit;
    private Long requestsRemaining;
    private Long tokensLimit;
    private Long tokensRemaining;

}
