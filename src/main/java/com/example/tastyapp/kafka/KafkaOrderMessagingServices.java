package com.example.tastyapp.kafka;

import com.example.tastyapp.controller.ProductData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@Slf4j
public class KafkaOrderMessagingServices implements OrderMessagingServices {
    private final SimpMessagingTemplate simpMessagingTemplate;

    private final KafkaTemplate<String, List<ProductData>> kafkaTemplate;

    @Override
    public void sendOrder(List<ProductData> productDataList) {
        log.info("admin отправлено" + productDataList);
        kafkaTemplate.send("admin-topic", productDataList);
        /*simpMessagingTemplate.convertAndSend("/my-topic",productDataList);*/

    }
}
