package com.example.tastyapp.services;

import com.example.tastyapp.controller.ProductData;
import com.example.tastyapp.models.Order;
import com.example.tastyapp.models.Product;
import com.example.tastyapp.models.User;
import com.example.tastyapp.repositories.OrderRepository;
import com.example.tastyapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServices {
    private final OrderRepository repository;
    private final UserRepository userRepository;
    private final ProductServices productServices;

    public void saveOrder(Order order, List<ProductData> productDataList) {
        log.info(String.valueOf(productDataList));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        String userPhone = ((User) principal).getPhoneNumber();

        for (ProductData productData : productDataList) {

            Long productId = productData.getProductId();
            int count = productData.getCount();

            Product product = productServices.getProductById(productId);

            if (product != null && count > 0) {

                Order newOrder = new Order(order);

                newOrder.setUserPhone(userPhone);

                newOrder.setProductName(product.getNameBurger());

                newOrder.setCount(count);

                Order savedOrder = repository.save(newOrder);
            }
        }
    }
}