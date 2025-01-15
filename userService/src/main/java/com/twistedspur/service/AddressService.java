package com.twistedspur.service;

import com.twistedspur.dto.AddressDto;
import com.twistedspur.entity.Address;
import com.twistedspur.exception.NotFoundException;
import com.twistedspur.mapper.AddressMapper;
import com.twistedspur.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    AddressMapper addressMapper;

    // Create a new Address
    public AddressDto createAddress(AddressDto addressDto) {
        Address address = addressMapper.toEntity(addressDto);
        addressRepository.save(address);
        return addressMapper.toDto(address);
    }

    // Get all Addresses assigned to a User
    public List<AddressDto> getAllAddressesAssignedToUser(Integer userId) {
        List<Address> addressesAssignedUser = addressRepository.findAllByUserId(userId);
        return addressMapper.toDtos(addressesAssignedUser);
    }

    // Update an Address
    public AddressDto updateAddress(Integer id, AddressDto addressDto) {
        Optional<Address> address = addressRepository.findById(id);
        if (address.isPresent()) {
            Address existingAddress = addressMapper.partialUpdate(addressDto, address.get());
            Address updatedAddress = addressRepository.save(existingAddress);
            return addressMapper.toDto(updatedAddress);
        } else {
            throw new NotFoundException("Address not found");
        }
    }

    // Delete an address assigned a user
    public void deleteAddress(Integer id) {
        Optional<Address> address = addressRepository.findById(id);
        if (address.isPresent()) {
            addressRepository.delete(address.get());
        } else {
            throw new NotFoundException("Address not found");
        }
    }
}
