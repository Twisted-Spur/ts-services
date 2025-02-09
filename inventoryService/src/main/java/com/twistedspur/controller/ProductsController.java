package com.twistedspur.controller;

import com.azure.core.annotation.QueryParam;
import com.twistedspur.dto.ProductDto;
import com.twistedspur.service.ProductsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@Tag(name = "Products Management", description = "Operations to perform products management")
public class ProductsController {

    @Autowired
    ProductsService productsService;

    // Create a new product entry
    @PostMapping
    public ProductDto createPrint(
            @RequestPart("productDto") ProductDto productDto) {
        return productsService.createProduct(productDto);
    }

    // Get all Products under a category
    @GetMapping("/{catId}")
    public List<ProductDto> getProductsByCatId(@QueryParam("catId") Integer catId) {
        return productsService.getProductsByCatId(catId);
    }

    // Update a product
    @PutMapping
    public ProductDto updatePrint(
            @RequestPart("productDto") ProductDto productDto) {
        return productsService.updateProduct(productDto);
    }

    // Delete a product
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        productsService.deleteProduct(id);
    }
}
