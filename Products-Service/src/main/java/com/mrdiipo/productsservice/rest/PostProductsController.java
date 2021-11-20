package com.mrdiipo.productsservice.rest;

import com.mrdiipo.productsservice.commands.CreateProductCommand;
import com.mrdiipo.productsservice.rest.restModels.CreateProductRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/products") // http://localhost:8080/api/v1/products
public class PostProductsController {

    private final Environment environment;
    private final CommandGateway commandGateway;

    @Autowired
    public PostProductsController(Environment environment,
                                  CommandGateway commandGateway) {
        this.environment = environment;
        this.commandGateway = commandGateway;
    }


    @PostMapping
    public String createProduct(@RequestBody CreateProductRestModel createProductRestModel){

        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .price(createProductRestModel.getPrice())
                .quantity(createProductRestModel.getQuantity())
                .title(createProductRestModel.getTitle())
                .productId(UUID.randomUUID().toString())
                .build();

        String returnValue;

        try{
            returnValue = commandGateway.sendAndWait(createProductCommand);
        } catch (Exception e){
            returnValue = e.getLocalizedMessage();
        }
        return returnValue;
    }

}
