package com.example.tastyapp.kafka;

import com.example.tastyapp.controller.ProductData;

import java.util.List;

public interface OrderMessagingServices {
    void sendOrder(List<ProductData> productDataList);
}
