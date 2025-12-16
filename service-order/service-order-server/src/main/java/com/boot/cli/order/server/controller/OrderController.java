package com.boot.cli.order.server.controller;

import com.boot.cli.order.server.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public void create(){
        orderService.createOrder();
    }

    @GetMapping("/by-code")
    public void findByCode(@RequestParam("orderCode") String orderCode){
        orderService.findByCode(orderCode);
    }

}
