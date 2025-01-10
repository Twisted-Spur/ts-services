package com.twistedspur.mapper;

import com.twistedspur.entity.Address;
import com.twistedspur.dto.AddressDto;
import com.twistedspur.entity.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface AddressMapper {
    @Mapping(source = "userId", target = "user")
    Address toEntity(AddressDto addressDto);

    @InheritInverseConfiguration(name = "toEntity")
    AddressDto toDto(Address address);

    List<AddressDto> toDtos(List<Address> addressDtoList);

    @Mapping(target = "user", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)Address partialUpdate(AddressDto addressDto, @MappingTarget Address address);
}