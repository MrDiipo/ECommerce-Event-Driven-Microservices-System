package com.mrdiipo.productsservice.core.data;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    ProductEntity findProductEntityByProductId(String productId);
    ProductEntity findProductEntityByProductIdOrTitle(String productId, String title);
}
