package com.example.tastyapp.configurations.test;

import com.example.tastyapp.controller.ProductData;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.net.http.WebSocket;
import java.util.List;

@Controller
public class ChefWebSocketController {

    @MessageMapping("/chef")
    @SendTo("/my-topic")
    public OrderMessage sendOrder(List<ProductData> order) throws Exception {
        return new OrderMessage(order);
    }
}