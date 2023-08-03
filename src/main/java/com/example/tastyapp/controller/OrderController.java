package com.example.tastyapp.controller;

import com.example.tastyapp.kafka.KafkaOrderMessagingServices;
import com.fasterxml.jackson.core.type.TypeReference;
import com.example.tastyapp.models.Order;
import com.example.tastyapp.services.OrderServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j

public class OrderController {

    private final OrderServices orderServices;
    private final KafkaOrderMessagingServices kafkaOrderMessagingServices;

    @GetMapping("/order")
    public String order() {
        return "order";
    }

    @PostMapping("/order/create")
    public String createOrder(Model model, @RequestBody MultiValueMap<String, String> formData, Order order) {

        String productDataListJson = formData.getFirst("productData");

        ObjectMapper objectMapper = new ObjectMapper();
        List<ProductData> productList = new ArrayList<>();

        try {
            productList = objectMapper.readValue(productDataListJson, new TypeReference<List<ProductData>>() {});
        } catch (Exception e) {
            log.info("пусто: " + productDataListJson);
            e.printStackTrace();
        }


        kafkaOrderMessagingServices.sendOrder(productList);

        // orderServices.saveOrder(order,productList);
        model.addAttribute("order",order);
        model.addAttribute("productList",productList);
        return "delivery";
    }
}
