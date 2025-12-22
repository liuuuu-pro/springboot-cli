package com.boot.cli.ai.server.domain.bo.spring;

import lombok.Data;

@Data
public class RespResultOutputBO {

    private RespResultOutputMetadataBO metadata;
    private String messageType;
    private String text;

}
