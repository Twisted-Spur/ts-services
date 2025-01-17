package com.twistedspur.mapper;

import com.twistedspur.dto.SkuAttributeDto;
import com.twistedspur.entity.SkuAttribute;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SkuAttributeMapper {
    SkuAttribute toEntity(SkuAttributeDto skuAttributeDto);

    SkuAttributeDto toDto(SkuAttribute skuAttribute);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    SkuAttribute partialUpdate(SkuAttributeDto skuAttributeDto, @MappingTarget SkuAttribute skuAttribute);
}