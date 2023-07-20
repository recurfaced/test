package com.example.tastyapp.services;

import com.example.tastyapp.models.Order;
import com.example.tastyapp.models.User;
import com.example.tastyapp.repositories.OrderRepository;
import com.example.tastyapp.repositories.UserRepository;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServices {
    private final OrderRepository repository;
    private final UserRepository userRepository;

    public void saveOrder(Order order) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Get the principal object from authentication (it should be your custom User class implementing UserDetails)
        Object principal = authentication.getPrincipal();

        // Assuming your User class has a method to get the user ID, replace 'getId()' with the appropriate method
        String userPhone = ((User) principal).getPhoneNumber();

        // Now you have the user's ID and can use it as needed.
        order.setUserPhone(userPhone);
        Order savedOrder = repository.save(order);
        repository.save(savedOrder);

    }
}
