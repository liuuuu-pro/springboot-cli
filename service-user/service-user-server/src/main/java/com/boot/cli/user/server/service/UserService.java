package com.boot.cli.user.server.service;

import com.boot.cli.user.model.vo.UserInfoVO;

public interface UserService {

    UserInfoVO getByUserCode(String userCode);

}
