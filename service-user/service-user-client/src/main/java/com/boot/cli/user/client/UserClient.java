package com.boot.cli.user.client;

import com.boot.cli.user.model.vo.UserInfoVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "service-user", path = "/user")
public interface UserClient {

    @GetMapping("/by-code")
    UserInfoVO getByUserCode(@RequestParam("userCode") String userCode);

}
