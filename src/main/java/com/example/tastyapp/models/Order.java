package com.example.tastyapp.models;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String deliveryName;

    private String deliveryStreet;

    private String deliveryCity;

    private String deliveryApartment;

    private String ccNumber;

    private String ccExpiration;

    private String ccCVV;

    private String productId;

    private String userPhone;

    @ManyToOne
    private User user;
    private LocalDateTime placedAt;


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "order")
    private List<User> users = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "order")
    private List<Product> products = new ArrayList<>();

    @PrePersist
    private void init() {
        placedAt = LocalDateTime.now();
    }
    public void addUserToOrder(User user) {
        user.setOrder(this);
    }

    public void addProductToOrder(Product product) {
        product.setOrder(this);
    }

}
