package com.technicalassignment.technicalassignment.service;

import java.util.List;
import java.util.UUID;

import com.technicalassignment.technicalassignment.model.Product;

public interface ProductService {

    List<Product> findAllProducts();

    Product findByProductId(UUID productId);

    Product createProduct(Product product);

    Product updateProduct(UUID productId, Product product);

    void deleteProduct(UUID productId);

}
