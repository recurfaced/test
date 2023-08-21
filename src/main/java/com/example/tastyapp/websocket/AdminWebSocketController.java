package com.example.tastyapp.websocket;


import com.example.tastyapp.controller.ProductData;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AdminWebSocketController {

    @MessageMapping({"/client-admin", "/about-order"})
    @SendTo("/my-topic")
    public OrderMessage sendOrder(List<ProductData> order) throws Exception {
        return new OrderMessage(order);
    }
}
