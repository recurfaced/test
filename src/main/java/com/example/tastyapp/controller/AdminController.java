package com.example.tastyapp.controller;


import com.example.tastyapp.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminController {
    private final UserServices userServices;

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/admin-control")
    public String adminControl(Model model){
        model.addAttribute("users",userServices.list());
        return "admin-control";
    }
}
