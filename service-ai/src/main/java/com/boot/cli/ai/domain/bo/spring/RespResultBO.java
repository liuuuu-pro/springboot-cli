package com.boot.cli.ai.domain.bo.spring;

import lombok.Data;

@Data
public class RespResultBO {

    private RespResultMetadataBO metadata;
    private RespResultOutputBO output;

}
