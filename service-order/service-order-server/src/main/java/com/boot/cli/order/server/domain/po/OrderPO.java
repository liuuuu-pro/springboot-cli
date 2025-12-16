package com.boot.cli.order.server.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_order")
public class OrderPO {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String orderCode;

}
