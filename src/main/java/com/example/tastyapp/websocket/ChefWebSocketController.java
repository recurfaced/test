package com.example.tastyapp.websocket;

import com.example.tastyapp.controller.ProductData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Data
@Slf4j
public class ChefWebSocketController {

    @MessageMapping("/chef")
    @SendTo("/my-topic")
    public List<ProductData> receiveOrder(@Payload List<ProductData> order) {
        log.info("контроллеру шефа пришло " + order);
        return order;
    }
}