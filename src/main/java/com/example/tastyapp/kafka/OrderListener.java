package com.example.tastyapp.kafka;

import com.example.tastyapp.controller.ProductData;
import lombok.Data;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class OrderListener {
    KitchenUI ui;

    public OrderListener(KitchenUI ui){
        this.ui = ui;
    }

    @KafkaListener(topics = "my-topic",groupId = "test-consumer-group")
    public void handle(List<ProductData> productDataList){
        ui.displayOrder(productDataList);
    }
}
