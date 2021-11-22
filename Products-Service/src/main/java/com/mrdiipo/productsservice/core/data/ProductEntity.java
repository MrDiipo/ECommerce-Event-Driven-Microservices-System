package com.mrdiipo.productsservice.core.data;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "products")
public class ProductEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -2671294608197172601L;

    @Id
    @Column(unique = true)
    private String productId;

    private String title;
    private BigDecimal price;
    private Integer quantity;

}
