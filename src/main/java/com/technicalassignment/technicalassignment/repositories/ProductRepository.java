package com.technicalassignment.technicalassignment.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.technicalassignment.technicalassignment.model.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Query(value = "select * from product where id = ?1", nativeQuery = true)
    Product findByProductId(UUID productId);

}
