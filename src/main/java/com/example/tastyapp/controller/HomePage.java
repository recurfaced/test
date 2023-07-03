package com.example.tastyapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomePage {
    @GetMapping("/")
    public String homePage(){
        return "home";
    }
}
