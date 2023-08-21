package com.example.tastyapp.services;

import com.example.tastyapp.controller.ProductData;
import com.example.tastyapp.models.Product;
import com.example.tastyapp.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChefServices {

    private final ProductRepository productRepository;

    public String determineChefForOrder(List<ProductData> productList){

        for (ProductData productData: productList){
            String productName =productData.getProductName();
            Optional<Product> productOptional = productRepository.findByNameBurger(productName);

            if (productOptional.isPresent()){
                Product product = productOptional.get();
                String productType =product.getProductType();
                return productType;
            }
        }

        return "";
    }
}
