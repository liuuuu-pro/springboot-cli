package com.boot.cli.user.model.vo;

import lombok.Builder;

@Builder
public record UserInfoVO(String userCode, String userName) {

}
