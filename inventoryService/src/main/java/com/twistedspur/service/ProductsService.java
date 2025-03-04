package com.twistedspur.service;

import com.twistedspur.dto.ProductDto;
import com.twistedspur.entity.Product;
import com.twistedspur.exception.NotFoundException;
import com.twistedspur.mapper.ProductMapper;
import com.twistedspur.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private ProductMapper productMapper;

    public ProductDto createProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        productsRepository.save(product);
        return productMapper.toDto(product);
    }

    public List<ProductDto> getProductsByCatId(Integer catId) {
        List<Product> products = productsRepository.findAllByCategoryId(catId);
        return productMapper.toDtos(products);
    }

    public ProductDto updateProduct(ProductDto productDto) {
        Optional<Product> optProduct = productsRepository.findById(productDto.id());

        if (optProduct.isEmpty()) {
            throw new NotFoundException("Product with id " + productDto.id() + " not found");
        }

        Product product = optProduct.get();
        productMapper.partialUpdate(productDto, product);
        productsRepository.save(product);

        return productMapper.toDto(product);
    }

    public void deleteProduct(Integer id) {
        productsRepository.deleteById(id);
    }
}
