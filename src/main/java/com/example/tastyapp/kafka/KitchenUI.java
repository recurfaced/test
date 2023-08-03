package com.example.tastyapp.kafka;

import com.example.tastyapp.controller.ProductData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class KitchenUI {
    public void displayOrder(List<ProductData> productDataList){
        log.info("получено: " + productDataList);
    }
}
