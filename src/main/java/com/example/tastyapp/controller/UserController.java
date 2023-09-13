package com.example.tastyapp.controller;

import com.example.tastyapp.models.Order;
import com.example.tastyapp.models.User;
import com.example.tastyapp.services.OrderServices;
import com.example.tastyapp.services.UserServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserServices userService;
    private final OrderServices orderServices;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(User user, Model model) {
        if (!userService.createUser(user)) {
            model.addAttribute("errorMessage", "Пользователь с email:" + user.getEmail() + " уже существует ");
            return "registration";
        }
        return "redirect:/login";
    }
    @GetMapping("/user/{user}")
    public String userInfo(@PathVariable("user") User user, Model model) {
        Long userId = user.getId();
        log.info("user id " + userId);
        List<Order> userOrders = orderServices.getOrdersByUserId(userId);

        log.info(userOrders.toString());
        model.addAttribute("orders", userOrders);
        return "user-info";
    }


}


