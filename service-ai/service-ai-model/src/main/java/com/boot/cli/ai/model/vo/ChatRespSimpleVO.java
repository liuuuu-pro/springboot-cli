package com.boot.cli.ai.model.vo;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.boot.cli.ai.model.bo.spring.RespBO;
import lombok.Builder;

import java.util.List;
import java.util.Objects;

@Builder
public record ChatRespSimpleVO(String text, UsageVO usage) {

    public static ChatRespSimpleVO of() {
        return ChatRespSimpleVO.builder().text(StrUtil.EMPTY).usage(UsageVO.of()).build();
    }

    public static ChatRespSimpleVO of(List<RespBO> contents) {
        if (CollUtil.isEmpty(contents)) {
            return ChatRespSimpleVO.of();
        } else {
            StringBuilder message = new StringBuilder();
            contents.forEach(content -> {
                if (Objects.nonNull(content)) {
                    String contentText = content.getText();
                    message.append(contentText);
                }
            });
            return ChatRespSimpleVO.builder()
                    .text(message.toString())
                    .usage(UsageVO.of(CollUtil.getLast(contents).getUsage()))
                    .build();
        }
    }

}
