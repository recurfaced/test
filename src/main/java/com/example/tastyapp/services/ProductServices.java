package com.example.tastyapp.services;

import com.example.tastyapp.models.Ingredient;
import com.example.tastyapp.models.NutritionalValue;
import com.example.tastyapp.models.Product;
import com.example.tastyapp.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServices {

    private final ProductRepository productRepository;

    public void saveBurger(MultipartFile file,
                           Product product,
                           Ingredient ingredient, NutritionalValue nutritionalValue) throws IOException {
        Product savedProduct = productRepository.save(product);
        if (file != null && !file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            String imagePath = "src/main/resources/static/images/" + fileName;

            Path destination = Path.of(imagePath);
            Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);

            savedProduct.setImagePath("/images/" + fileName);
            savedProduct.addIngredientToProduct(ingredient);
            savedProduct.addNutritionalValuesToProduct(nutritionalValue);
            productRepository.save(savedProduct);
        }
        }

        public Product getProductById(Long id){
        return productRepository.findById(id).orElse(null);
        }


    public List<Product> productList() {
        return productRepository.findAll();
    }
}