package com.twistedspur.mapper;

import com.twistedspur.dto.OrderStatusDto;
import com.twistedspur.entity.OrderStatus;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderStatusMapper {
    OrderStatus toEntity(OrderStatusDto orderStatusDto);

    OrderStatusDto toDto(OrderStatus orderStatus);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    OrderStatus partialUpdate(OrderStatusDto orderStatusDto, @MappingTarget OrderStatus orderStatus);
}