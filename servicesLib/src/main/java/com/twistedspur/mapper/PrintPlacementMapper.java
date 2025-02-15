package com.twistedspur.mapper;

import com.twistedspur.dto.PrintPlacementDto;
import com.twistedspur.entity.PrintPlacement;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PrintPlacementMapper {
    PrintPlacement toEntity(PrintPlacementDto printPlacementDto);

    PrintPlacementDto toDto(PrintPlacement printPlacement);

    List<PrintPlacementDto> toDto(List<PrintPlacement> printPlacements);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PrintPlacement partialUpdate(PrintPlacementDto printPlacementDto, @MappingTarget PrintPlacement printPlacement);
}