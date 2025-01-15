package com.twistedspur.mapper;

import com.twistedspur.dto.PrintDto;
import com.twistedspur.entity.Print;
import org.mapstruct.BeanMapping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CategoryMapper.class, TransferTypeMapper.class})
public interface PrintMapper {
    @Mapping(target = "transferType", source = "transferTypeId")
    @Mapping(target = "category", source = "categoryId")
    Print toEntity(PrintDto printDto);

    @InheritInverseConfiguration(name = "toEntity")
    PrintDto toDto(Print print);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "transferType", source = "transferTypeId")
    @Mapping(target = "category", source = "categoryId")
    Print partialUpdate(PrintDto printDto, @MappingTarget Print print);
}