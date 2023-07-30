package com.example.tastyapp.controller;

import com.example.tastyapp.models.Order;
import com.example.tastyapp.services.OrderServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@Controller
@RequiredArgsConstructor
@Slf4j

public class OrderController {

    private final OrderServices orderServices;
    @GetMapping("/order")
    public String order(){
        return "order";
    }
    @PostMapping("/order/create")
    public String createOrder(@RequestBody String productDataList, Order order) {

        log.info(order.getDeliveryCity());
        log.info(productDataList);

        return "delivery";
    }
}
