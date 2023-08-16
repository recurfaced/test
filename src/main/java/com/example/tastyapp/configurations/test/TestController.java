package com.example.tastyapp.configurations.test;

import com.example.tastyapp.controller.ProductData;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

import java.text.SimpleDateFormat;
import java.util.Date;

@org.springframework.stereotype.Controller
public class TestController {
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public ProductData send(Message message) throws Exception {
        ProductData productData = new ProductData(message.getProductName());
        productData.setTime(new Date());
        return productData;
    }
}