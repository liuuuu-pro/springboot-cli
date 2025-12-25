CREATE TABLE IF NOT EXISTS t_order (
    id BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    order_code VARCHAR(30) NOT NULL COMMENT '订单编码',
PRIMARY KEY (id),
UNIQUE KEY uk_order_code (order_code)
) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci
COMMENT='订单表';