package com.twistedspur.mapper;

import com.twistedspur.dto.OrderDetailDto;
import com.twistedspur.entity.OrderDetail;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderDetailMapper {
    OrderDetail toEntity(OrderDetailDto orderDetailDto);

    OrderDetailDto toDto(OrderDetail orderDetail);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    OrderDetail partialUpdate(OrderDetailDto orderDetailDto, @MappingTarget OrderDetail orderDetail);
}