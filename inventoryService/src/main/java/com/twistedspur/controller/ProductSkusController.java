package com.twistedspur.controller;

import com.twistedspur.dto.ProductSkusDto;
import com.twistedspur.service.ProductSkusService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productskus")
@Tag(name = "Product SKU Management", description = "Operations to perform product SKU management")
public class ProductSkusController {

    @Autowired
    ProductSkusService productSkusService;

    // Create a new product sku
    @PostMapping
    public ProductSkusDto createProductSku(@RequestBody ProductSkusDto productSkusDto) {
        return productSkusService.createProductSku(productSkusDto);
    }

    // Get all Products skus under a product
    @GetMapping("/{productId}")
    public List<ProductSkusDto> getProductSkusByProductId(@PathVariable Integer productId) {
        return productSkusService.getProductSkusByProductId(productId);
    }

    // Update a product sku
    @PutMapping
    public ProductSkusDto updateProductSku(@RequestBody ProductSkusDto productSkusDto) {
        return productSkusService.updateProductSku(productSkusDto);
    }

    // Delete a product sku
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        productSkusService.deleteProductSku(id);
    }
}
