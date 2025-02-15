package com.twistedspur.service;

import com.twistedspur.dto.ProductDto;
import com.twistedspur.dto.ProductSkusDto;
import com.twistedspur.entity.Product;
import com.twistedspur.entity.ProductSkus;
import com.twistedspur.exception.NotFoundException;
import com.twistedspur.mapper.ProductMapper;
import com.twistedspur.mapper.ProductSkusMapper;
import com.twistedspur.repository.ProductSkusRepository;
import com.twistedspur.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductSkusService {
    @Autowired
    private ProductSkusRepository productSkusRepository;

    @Autowired
    private ProductSkusMapper productSkusMapper;

    public ProductSkusDto createProductSku(ProductSkusDto productSkusDto) {
        ProductSkus productSku = productSkusMapper.toEntity(productSkusDto);
        productSkusRepository.save(productSku);
        return productSkusMapper.toDto(productSku);
    }

    public List<ProductSkusDto> getProductSkusByProductId(Integer productId) {
        List<ProductSkus> productSkus = productSkusRepository.findAllById(List.of(productId));
        return productSkusMapper.toDto(productSkus);
    }

    public ProductSkusDto updateProductSku(ProductSkusDto productSkusDto) {
        Optional<ProductSkus> optProductSku = productSkusRepository.findById(productSkusDto.id());

        if (optProductSku.isEmpty()) {
            throw new NotFoundException("Product sku with id " + productSkusDto.id() + " not found");
        }

        ProductSkus productSku = optProductSku.get();
        productSkusMapper.partialUpdate(productSkusDto, productSku);
        productSkusRepository.save(productSku);

        return productSkusMapper.toDto(productSku);
    }

    public void deleteProductSku(Integer id) {
        productSkusRepository.deleteById(id);
    }
}
