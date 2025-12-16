package com.boot.cli.order.server.service;

public interface OrderService {

    void createOrder();
    void findByCode(String orderCode);

}
