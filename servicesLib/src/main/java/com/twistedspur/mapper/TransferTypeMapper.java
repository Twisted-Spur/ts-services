package com.twistedspur.mapper;

import com.twistedspur.dto.TransferTypeDto;
import com.twistedspur.entity.TransferType;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TransferTypeMapper {
    TransferType toEntity(TransferTypeDto transferTypeDto);

    TransferTypeDto toDto(TransferType transferType);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TransferType partialUpdate(TransferTypeDto transferTypeDto, @MappingTarget TransferType transferType);

    default TransferType mapTransferTypeIdToTransferType(Integer transferTypeId) {
        if (transferTypeId == null) {
            return null;
        }
        TransferType transferType = new TransferType();
        transferType.setId(transferTypeId);
        return transferType;
    }

    default Integer mapTransferTypeToIntegerId(TransferType transferType) {
        return transferType == null ? null : transferType.getId();
    }
}