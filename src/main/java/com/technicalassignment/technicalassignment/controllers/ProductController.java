package com.technicalassignment.technicalassignment.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.technicalassignment.technicalassignment.model.Product;
import com.technicalassignment.technicalassignment.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /* Get All Products */
    @Operation(summary = "Get all products", description = "Retrieve the list of all products.")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list of products")
    @GetMapping
    public List<Product> getAllProduct() {
        return productService.findAllProducts();
    }

    /* Get Product By Product Id */
    @Operation(summary = "Get product by ID", description = "Provide a product ID to fetch a specific product.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved product"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable UUID id) {
        return productService.findByProductId(id);
    }

    /* Create Product */
    @Operation(summary = "Create a new product", description = "Provide the product details to create a new product.")
    @ApiResponse(responseCode = "201", description = "Product successfully created")
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @Operation(summary = "Update an existing product", description = "Provide the product ID and new details to update the product.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated product"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable UUID id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @Operation(summary = "Delete a product", description = "Provide the product ID to delete the specific product.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted product"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable UUID id) {
        productService.deleteProduct(id);
    }
}
