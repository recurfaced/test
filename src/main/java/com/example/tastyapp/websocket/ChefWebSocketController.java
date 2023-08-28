package com.example.tastyapp.websocket;

import com.example.tastyapp.controller.ProductData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@Data
public class ChefWebSocketController {

    @MessageMapping("/chef")
    @SendTo("/my-topic")
    public String sendOrder(List<ProductData> order) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String orderJson = objectMapper.writeValueAsString(order);
        return orderJson;
    }
}