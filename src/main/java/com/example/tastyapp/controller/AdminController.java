package com.example.tastyapp.controller;


import com.example.tastyapp.models.Order;
import com.example.tastyapp.services.UserServices;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
@Slf4j
@Data
@RequiredArgsConstructor
//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminController {
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final UserServices userServices;

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/client-admin")
    public String clientAdmin(){
        return "client-admin";
    }

    @PostMapping("/client-admin")
    public ResponseEntity<String> createOrder(@RequestBody List<ProductData> productList) {
        // Сохранить productList в базе данных или выполнить необходимую обработку

        // Отправить productList всем подписчикам на /my-topic
        simpMessagingTemplate.convertAndSend("/my-topic", productList);

        return ResponseEntity.ok("Список продуктов создан и отправлен всем подписчикам.");
    }

    @GetMapping("/admin-control")
    public String adminControl(Model model){
        model.addAttribute("users",userServices.list());
        return "admin-control";
    }
    @GetMapping("/about-order")
    public String aboutOrder(Model model, @RequestParam("productList") String productListJson) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<ProductData> productList = new ArrayList<>();

        try {
            productList = objectMapper.readValue(productListJson, new TypeReference<List<ProductData>>() {});
        } catch (Exception e) {
            log.error("Ошибка при преобразовании JSON: " + e.getMessage());
        }
        log.info(" че отправляется то - "+productList.toString());

        model.addAttribute("productList", productList);

        return "about-order";
    }
}
