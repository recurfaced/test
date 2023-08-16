package com.example.tastyapp.controller;

import lombok.Data;

import java.util.Date;

@Data
public class ProductData {
    private Long productId;
    private int count;
    private String productName;
    private double price;
    private Date time;

    public ProductData() {
    }

    public ProductData(String productName){
        this.productName = productName;
        this.time = new Date();
    }

    public ProductData(Long productId, int count) {
        this.productId = productId;
        this.count = count;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Getters and setters
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}