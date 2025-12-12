package com.boot.cli.ai.domain.bo.spring;

import lombok.Data;

@Data
public class RespResultOutputBO {

    private RespResultOutputMetadataBO metadata;
    private String messageType;
    private String text;

}
