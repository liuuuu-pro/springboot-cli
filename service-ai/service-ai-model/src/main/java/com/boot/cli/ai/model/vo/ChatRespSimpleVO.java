package com.boot.cli.ai.model.vo;

public record ChatRespSimpleVO(String text, UsageVO usage) {

    public static ChatRespSimpleVO of() {
        return new ChatRespSimpleVO("", UsageVO.of());
    }

}
