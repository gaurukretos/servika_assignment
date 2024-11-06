package com.technicalassignment.technicalassignment.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.technicalassignment.technicalassignment.model.Product;

import com.technicalassignment.technicalassignment.exceptionhandler.ProductNotFoundException;
import com.technicalassignment.technicalassignment.repositories.ProductRepository;
import com.technicalassignment.technicalassignment.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /* Find All Products */
    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    /* Find Product By Product Id */
    @Override
    public Product findByProductId(UUID productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product == null) {
            throw new ProductNotFoundException("Product not found with id " + productId);
        }
        return product;
    }

    /* Create Product */
    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    /* Update Products */
    @Override
    public Product updateProduct(UUID productId, Product product) {
        Product products = productRepository.findByProductId(productId);
        if (products != null) {
            products.setName(product.getName());
            products.setDescription(product.getDescription());
            products.setPrice(product.getPrice());
        }
        return productRepository.save(products);

    }

    /* Delete Product Id */

    @Override
    public void deleteProduct(UUID productId) {
        productRepository.deleteById(productId);
    }

}
