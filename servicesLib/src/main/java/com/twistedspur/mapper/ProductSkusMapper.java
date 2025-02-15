package com.twistedspur.mapper;

import com.twistedspur.dto.ProductSkusDto;
import com.twistedspur.entity.ProductSkus;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductSkusMapper {
    ProductSkus toEntity(ProductSkusDto productSkusDto);

    ProductSkusDto toDto(ProductSkus productSkus);

    List<ProductSkusDto> toDto(List<ProductSkus> productSkusList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ProductSkus partialUpdate(ProductSkusDto productSkusDto, @MappingTarget ProductSkus productSkus);
}