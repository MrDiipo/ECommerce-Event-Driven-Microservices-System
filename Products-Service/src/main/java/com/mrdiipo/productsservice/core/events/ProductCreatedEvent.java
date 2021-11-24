package com.mrdiipo.productsservice.core.events;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductCreatedEvent {

    private String productId;
    private String title;
    private BigDecimal price;
    private Integer quantity;

}
