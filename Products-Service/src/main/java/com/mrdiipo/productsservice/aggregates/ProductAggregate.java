package com.mrdiipo.productsservice.aggregates;

import com.mrdiipo.productsservice.commands.CreateProductCommand;
import com.mrdiipo.productsservice.coreEvents.ProductCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Aggregate
@NoArgsConstructor
public class ProductAggregate {

    @AggregateIdentifier
    private String productId;
    private String title;
    private BigDecimal price;
    private Integer quantity;

    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand){
        // Validate create product command
        if (createProductCommand.getPrice().compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Price cannot be less or equal to zero");

        if (createProductCommand.getTitle().isBlank() || createProductCommand.getTitle() == null)
            throw new IllegalArgumentException("Title cannot be empty");

        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent();

        BeanUtils.copyProperties(createProductCommand, productCreatedEvent);

        AggregateLifecycle.apply(productCreatedEvent);
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent productCreatedEvent){
        this.price = productCreatedEvent.getPrice();
        this.productId = productCreatedEvent.getProductId();
        this.quantity = productCreatedEvent.getQuantity();
        this.title = productCreatedEvent.getTitle();
    }
}
