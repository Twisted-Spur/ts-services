package com.twistedspur.service;

import com.twistedspur.dto.ProductSkusDto;
import com.twistedspur.dto.SkuAttributeDto;
import com.twistedspur.entity.ProductSkus;
import com.twistedspur.entity.SkuAttribute;
import com.twistedspur.exception.NotFoundException;
import com.twistedspur.mapper.SkuAttributeMapper;
import com.twistedspur.repository.SkuAttributesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkuAttributesService {
    @Autowired
    private SkuAttributesRepository skuAttributesRepository;

    @Autowired
    private SkuAttributeMapper skuAttributeMapper;

    public SkuAttributeDto createSkuAttribute(SkuAttributeDto productSkusDto) {
        SkuAttribute skuAttribute = skuAttributeMapper.toEntity(productSkusDto);
        skuAttributesRepository.save(skuAttribute);
        return skuAttributeMapper.toDto(skuAttribute);
    }

    public List<SkuAttributeDto> getSkuAttributesByProductSkuId(Integer productId) {
        List<SkuAttribute> skuAttributes = skuAttributesRepository.findAllById(List.of(productId));
        return skuAttributeMapper.toDto(skuAttributes);
    }

    public SkuAttributeDto updateSkuAttribute(SkuAttributeDto skuAttributeDto) {
        Optional<SkuAttribute> optSkuAttribute = skuAttributesRepository.findById(skuAttributeDto.id());

        if (optSkuAttribute.isEmpty()) {
            throw new NotFoundException("Product sku with id " + skuAttributeDto.id() + " not found");
        }

        SkuAttribute skuAttribute = optSkuAttribute.get();
        skuAttributeMapper.partialUpdate(skuAttributeDto, skuAttribute);
        skuAttributesRepository.save(skuAttribute);

        return skuAttributeMapper.toDto(skuAttribute);
    }

    public void deleteSkuAttribute(Integer id) {
        skuAttributesRepository.deleteById(id);
    }
}
