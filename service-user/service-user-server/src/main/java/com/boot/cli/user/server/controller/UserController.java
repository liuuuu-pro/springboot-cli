package com.boot.cli.user.server.controller;

import com.boot.cli.user.model.vo.UserInfoVO;
import com.boot.cli.user.server.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/info")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/by-code")
    public UserInfoVO getByUserCode(@RequestParam("userCode") String userCode) {
        return userService.getByUserCode(userCode);
    }

}
