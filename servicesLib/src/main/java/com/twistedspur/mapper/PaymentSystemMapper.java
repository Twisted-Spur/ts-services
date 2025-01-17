package com.twistedspur.mapper;

import com.twistedspur.dto.PaymentSystemDto;
import com.twistedspur.entity.PaymentSystem;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PaymentSystemMapper {
    PaymentSystem toEntity(PaymentSystemDto paymentSystemDto);

    PaymentSystemDto toDto(PaymentSystem paymentSystem);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PaymentSystem partialUpdate(PaymentSystemDto paymentSystemDto, @MappingTarget PaymentSystem paymentSystem);
}