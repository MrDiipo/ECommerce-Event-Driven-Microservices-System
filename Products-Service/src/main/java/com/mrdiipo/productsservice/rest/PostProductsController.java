package com.mrdiipo.productsservice.rest;

import com.mrdiipo.productsservice.rest.restModels.CreateProductRestModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/products") // http://localhost:8080/api/v1/products
public class PostProductsController {

    @PostMapping
    public String createProduct(@RequestBody CreateProductRestModel createProductRestModel){
        return null;
    }

}
