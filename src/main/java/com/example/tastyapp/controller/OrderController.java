package com.example.tastyapp.controller;

import com.example.tastyapp.models.Order;
import com.example.tastyapp.models.User;
import com.example.tastyapp.services.OrderServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

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
    public String createOrder(Order order){
        orderServices.saveOrder(order);
        return "delivery";
    }
}
