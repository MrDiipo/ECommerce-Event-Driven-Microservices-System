package com.mrdiipo.productsservice.aggregates;

import com.mrdiipo.productsservice.commands.CreateProductCommand;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigDecimal;

@Aggregate
@NoArgsConstructor
public class ProductAggregate {

    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand){
        // Validate create product command
        if (createProductCommand.getPrice().compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Price cannot be less or equal to zero");

        if (createProductCommand.getTitle().isBlank() || createProductCommand.getTitle() == null)
            throw new IllegalArgumentException("Title cannot be empty");
    }
}
