package com.example.tastyapp.websocket;

import com.example.tastyapp.controller.ProductData;
import lombok.Data;

import java.util.List;
@Data
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