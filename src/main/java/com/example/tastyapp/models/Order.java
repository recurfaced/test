package com.example.tastyapp.models;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Orders")
public class Order {

    public Order(Order other) {
        this.id = other.id;
        this.deliveryName = other.deliveryName;
        this.deliveryStreet = other.deliveryStreet;
        this.deliveryCity = other.deliveryCity;
        this.deliveryApartment = other.deliveryApartment;
        this.ccNumber = other.ccNumber;
        this.ccExpiration = other.ccExpiration;
        this.ccCVV = other.ccCVV;
        this.productName = other.productName;
        this.userPhone = other.userPhone;
        this.received = other.received;
    }

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

    private String productName;

    private String userPhone;

    private boolean received;

    private Integer count;
    private Integer price;

    private Long userOrderId;

    @ManyToOne
    private User user;
    private LocalDateTime placedAt;


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "order")
    private List<User> users = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "order")
    private List<Product> products = new ArrayList<>();


    public Order() {

    }

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
