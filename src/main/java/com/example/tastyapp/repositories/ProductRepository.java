package com.example.tastyapp.repositories;

import com.example.tastyapp.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {


    @Query("SELECT p FROM Product p WHERE p.nameBurger = :name")
    Optional<Product> findByNameBurger(String name);
}
