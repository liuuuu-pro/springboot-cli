package com.boot.cli.user.server.service.impl;

import com.boot.cli.user.model.vo.UserInfoVO;
import com.boot.cli.user.server.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserInfoVO getByUserCode(String userCode) {
        log.info("Get user info by user code:{}", userCode);
        return UserInfoVO.builder().userCode("admin").userName("DemoAdmin").build();
    }

}
