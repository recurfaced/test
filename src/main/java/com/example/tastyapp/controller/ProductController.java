package com.example.tastyapp.controller;

import com.example.tastyapp.models.Ingredient;
import com.example.tastyapp.models.NutritionalValue;
import com.example.tastyapp.models.Product;
import com.example.tastyapp.services.ProductServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductServices productService;


    @GetMapping("/product/all")
    public String products(Model model){
        Product product = new Product();
        model.addAttribute("products",productService.productList());
        return "products";
    }


    @GetMapping("/products")
    public String products(){
        return "products";
    }

    @PostMapping("/product/create")
    public String createProduct(@RequestParam("file") MultipartFile file,
                                Product product,
                                Ingredient ingredient, NutritionalValue nutritionalValue) throws IOException {
        productService.saveBurger(file,product,ingredient,nutritionalValue);

        return "redirect:/";
    }
    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id,Model model){

        Product product = productService.getProductById(id);
        model.addAttribute("products", product);
        return "product-info";
    }
}
