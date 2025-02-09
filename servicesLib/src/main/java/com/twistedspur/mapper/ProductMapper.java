package com.twistedspur.mapper;

import com.twistedspur.dto.ProductDto;
import com.twistedspur.entity.Product;
import org.mapstruct.BeanMapping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mapping(target = "category", source = "categoryId")
    Product toEntity(ProductDto productDto);

    @InheritInverseConfiguration(name = "toEntity")
    ProductDto toDto(Product product);

    List<ProductDto> toDtos(List<Product> products);

    @Mapping(target = "category", source = "categoryId")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Product partialUpdate(ProductDto productDto, @MappingTarget Product product);
}