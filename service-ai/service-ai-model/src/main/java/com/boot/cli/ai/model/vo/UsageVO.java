package com.boot.cli.ai.model.vo;

public record UsageVO(Long promptTokens, Long completionTokens, Long totalTokens) {

    public static UsageVO of() {
        return new UsageVO(0L, 0L, 0L);
    }

}
