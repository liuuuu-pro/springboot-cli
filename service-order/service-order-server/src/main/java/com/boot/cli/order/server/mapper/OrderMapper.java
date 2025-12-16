package com.boot.cli.order.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.cli.order.server.domain.po.OrderPO;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper extends BaseMapper<OrderPO> {
}
