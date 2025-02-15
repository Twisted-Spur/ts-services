package com.twistedspur.mapper;

import com.twistedspur.dto.PrintConfigurationDto;
import com.twistedspur.entity.PrintConfiguration;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PrintConfigurationMapper {
    PrintConfiguration toEntity(PrintConfigurationDto printConfigurationDto);

    PrintConfigurationDto toDto(PrintConfiguration printConfiguration);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PrintConfiguration partialUpdate(PrintConfigurationDto printConfigurationDto, @MappingTarget PrintConfiguration printConfiguration);
}