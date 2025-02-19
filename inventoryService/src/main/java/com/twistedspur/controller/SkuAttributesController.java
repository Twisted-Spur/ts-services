package com.twistedspur.controller;

import com.twistedspur.dto.SkuAttributeDto;
import com.twistedspur.service.SkuAttributesService;
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
@RequestMapping("/skuAttributes")
@Tag(name = "SKU Attributes Management", description = "Operations to perform SKU attributes management")
public class SkuAttributesController {

    @Autowired
    SkuAttributesService skuAttributesService;

    // Create a new product sku attribute
    @PostMapping
    public SkuAttributeDto createProductSku(@RequestBody SkuAttributeDto skuAttributeDto) {
        return skuAttributesService.createSkuAttribute(skuAttributeDto);
    }

    // Get all Products skus under a product attribute
    @GetMapping("/{productSkuId}")
    public List<SkuAttributeDto> getSkuAttributesByProductSkuId(@PathVariable Integer productSkuId) {
        return skuAttributesService.getSkuAttributesByProductSkuId(productSkuId);
    }

    // Update a product sku attribute
    @PutMapping
    public SkuAttributeDto updateSkuAttribute(@RequestBody SkuAttributeDto skuAttributeDto) {
        return skuAttributesService.updateSkuAttribute(skuAttributeDto);
    }

    // Delete a product sku attribute
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        skuAttributesService.deleteSkuAttribute(id);
    }
}
