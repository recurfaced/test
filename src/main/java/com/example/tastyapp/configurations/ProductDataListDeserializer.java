package com.example.tastyapp.configurations;

import com.example.tastyapp.controller.ProductData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.List;

public class ProductDataListDeserializer implements Deserializer<List<ProductData>> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<ProductData> deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(data, new TypeReference<List<ProductData>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }
    }
}
