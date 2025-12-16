CREATE TABLE t_order (
     id BIGINT NOT NULL AUTO_INCREMENT,
     order_code VARCHAR(30) NOT NULL,
     PRIMARY KEY (id)
);

CREATE INDEX idx_order_code ON t_order(order_code);