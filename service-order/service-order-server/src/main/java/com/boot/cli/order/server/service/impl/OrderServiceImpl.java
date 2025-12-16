package com.boot.cli.order.server.service.impl;

import com.boot.cli.common.core.util.Json;
import com.boot.cli.order.server.service.OrderService;
import com.boot.cli.user.client.UserClient;
import com.boot.cli.user.model.vo.UserInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserClient userClient;

    @Override
    public void createOrder() {
        log.info("create order...");
        UserInfoVO adminInfo = userClient.getByUserCode("admin");
        log.info("adminInfo:{}", Json.to(adminInfo));
    }

}
