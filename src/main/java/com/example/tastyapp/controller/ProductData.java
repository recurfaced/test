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

}