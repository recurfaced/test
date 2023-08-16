package com.example.tastyapp.controller;


import com.example.tastyapp.services.ProductServices;
import com.example.tastyapp.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class HomePage {
    private final UserServices userServices;
    @GetMapping("/")
    public String homePage(Principal principal, Model model){

        model.addAttribute("user",userServices.getUserByPrincipal(principal));
        return "home";
    }
}
