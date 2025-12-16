package com.boot.cli.order.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.boot.cli.common.core.util.Json;
import com.boot.cli.order.server.domain.po.OrderPO;
import com.boot.cli.order.server.mapper.OrderMapper;
import com.boot.cli.order.server.service.OrderService;
import com.boot.cli.user.client.UserClient;
import com.boot.cli.user.model.vo.UserInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserClient userClient;
    @Autowired
    private OrderMapper orderMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createOrder() {
        log.info("create order...");
        UserInfoVO adminInfo = userClient.getByUserCode("admin");
        log.info("adminInfo:{}", Json.to(adminInfo));
        OrderPO order = new OrderPO();
        order.setOrderCode(System.currentTimeMillis() + "");
        orderMapper.insert(order);
        log.info("insert order success:{}", order.getOrderCode());
    }

    @Override
    public void findByCode(String orderCode) {
        OrderPO order = orderMapper.selectOne(new LambdaQueryWrapper<OrderPO>().eq(OrderPO::getOrderCode, orderCode));
        log.info("orderId:{}", order.getId());
    }

}
