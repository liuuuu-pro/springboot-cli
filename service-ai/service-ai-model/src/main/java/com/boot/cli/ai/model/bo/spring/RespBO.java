package com.boot.cli.ai.model.bo.spring;

import lombok.Data;

import java.util.Objects;

@Data
public class RespBO {

    private RespMetadataBO metadata;
    private RespResultBO result;

    public String getText() {
        if (Objects.nonNull(result)
                && Objects.nonNull(result.getOutput())
                && Objects.nonNull(result.getOutput().getText())) {
            return result.getOutput().getText();
        }
        return "";
    }

    public RespMetadataUsageBO getUsage() {
        if (Objects.nonNull(metadata)) {
            return metadata.getUsage();
        }
        return null;
    }

    public String getFinishReason() {
        if (Objects.nonNull(result) && Objects.nonNull(result.getMetadata())) {
            return result.getMetadata().getFinishReason();
        }
        return null;
    }

}
