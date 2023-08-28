package com.example.tastyapp.kafka;

import com.example.tastyapp.controller.ProductData;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class KafkaOrderMessagingServices implements OrderMessagingServices {

    private final KafkaTemplate<String, List<ProductData>> kafkaTemplate;

    @Override
    public void sendOrder(List<ProductData> productDataList) {
        kafkaTemplate.send("admin-topic", productDataList);
    }
}
