package com.boot.cli.ai.model.bo.spring;

import lombok.Data;

@Data
public class RespMetadataBO {

    private String id;
    private String model;
    private RespMetadataLimitBO rateLimit;
    private RespMetadataUsageBO usage;

}
