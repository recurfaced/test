package com.example.tastyapp.websocket;


import com.example.tastyapp.controller.ProductData;
import com.example.tastyapp.models.Order;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Slf4j
@Data
public class AdminWebSocketController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/client-admin")
    @SendTo("/admin-topic")
    public void receiveOrder(Order order) {

        log.info("хуй хуй хуй хуй хуй");
    }
}