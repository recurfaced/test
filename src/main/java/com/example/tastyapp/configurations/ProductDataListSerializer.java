package com.example.tastyapp.configurations;

import com.example.tastyapp.controller.ProductData;
import org.apache.kafka.common.serialization.Serializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class ProductDataListSerializer implements Serializer<List<ProductData>> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String topic, List<ProductData> data) {
        try {
            return objectMapper.writeValueAsBytes(data);
        } catch (Exception e) {
            throw new RuntimeException("Error serializing ProductData list", e);
        }
    }
}
