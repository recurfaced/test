package com.example.tastyapp.repositories;

import com.example.tastyapp.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NutritionalValueRepository extends JpaRepository<Product,Long> {
}
