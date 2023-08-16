package com.example.tastyapp.configurations.test;

import com.example.tastyapp.controller.ProductData;

import java.util.List;

public class OrderMessage {
    private List<ProductData> content;

    public OrderMessage(List<ProductData> content) {
        this.content = content;
    }

    public List<ProductData> getContent() {
        return content;
    }

    public void setContent(List<ProductData> content) {
        this.content = content;
    }
}