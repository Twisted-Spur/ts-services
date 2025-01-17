package com.twistedspur.mapper;

import com.twistedspur.dto.PaymentStateDto;
import com.twistedspur.entity.PaymentState;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PaymentStateMapper {
    PaymentState toEntity(PaymentStateDto paymentStateDto);

    PaymentStateDto toDto(PaymentState paymentState);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PaymentState partialUpdate(PaymentStateDto paymentStateDto, @MappingTarget PaymentState paymentState);
}