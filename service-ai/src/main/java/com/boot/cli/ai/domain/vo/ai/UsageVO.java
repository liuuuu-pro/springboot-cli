package com.boot.cli.ai.domain.vo.ai;

import com.boot.cli.ai.domain.bo.spring.RespMetadataUsageBO;
import lombok.Builder;

@Builder
public record UsageVO(Long promptTokens, Long completionTokens, Long totalTokens) {

    public static UsageVO of() {
        return UsageVO.builder().promptTokens(0L).completionTokens(0L).totalTokens(0L).build();
    }

    public static UsageVO of(RespMetadataUsageBO usage) {
        return UsageVO.builder()
                .promptTokens(usage.getPromptTokens())
                .completionTokens(usage.getCompletionTokens())
                .totalTokens(usage.getTotalTokens())
                .build();
    }

}
