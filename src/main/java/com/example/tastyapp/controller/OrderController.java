package com.example.tastyapp.controller;
import com.example.tastyapp.services.ChefServices;
import com.example.tastyapp.kafka.KafkaOrderMessagingServices;
import com.example.tastyapp.services.OrderServices;
import com.fasterxml.jackson.core.type.TypeReference;
import com.example.tastyapp.models.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequiredArgsConstructor
@Slf4j

public class OrderController {

    private final KafkaOrderMessagingServices kafkaOrderMessagingServices;
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final ChefServices chefServices;
    private final OrderServices orderServices;


    @GetMapping("/order")
    public String order() {
        return "order";
    }


    @PostMapping("/order/create")
    public String createOrder(Model model, @RequestBody MultiValueMap<String, String> formData, Order order) throws Exception {

        String productDataListJson = formData.getFirst("productData");

        ObjectMapper objectMapper = new ObjectMapper();
        List<ProductData> productList = new ArrayList<>();

        try {
            productList = objectMapper.readValue(productDataListJson, new TypeReference<List<ProductData>>() {});
        } catch (Exception e) {
            log.info("пусто: " + productDataListJson);
            e.printStackTrace();
        }
        log.info(order.toString());

        String chefUsername = chefServices.determineChefForOrder(productList);
        log.info(chefUsername);
        Map<String, Object> orderData = new HashMap<>();
        orderData.put("order", order);
        orderData.put("productList", productDataListJson);




        log.info("лист"+ productList);
        kafkaOrderMessagingServices.sendOrder(productList);

        //simpMessagingTemplate.convertAndSend("/my-topic", productList);
        simpMessagingTemplate.convertAndSend("/admin-topic", orderData);
        //orderServices.saveOrder(order,productList);

        model.addAttribute("order", order);
        model.addAttribute("productList", productList);

        return "delivery";
    }
}
