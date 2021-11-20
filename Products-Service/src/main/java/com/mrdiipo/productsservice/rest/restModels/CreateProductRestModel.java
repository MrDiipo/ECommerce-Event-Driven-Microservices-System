package com.mrdiipo.productsservice.rest.restModels;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateProductRestModel {

    private String title;
    private BigDecimal price;
    private  Integer quantity;

}
