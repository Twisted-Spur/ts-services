package com.twistedspur.controller;

import com.twistedspur.entity.Address;
import com.twistedspur.dto.AddressDto;
import com.twistedspur.mapper.AddressMapper;
import com.twistedspur.repository.AddressRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
@Tag(name = "Address Management", description = "Operations to perform address management")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    AddressMapper addressMapper;

    // Create a new Address
    @PostMapping
    public AddressDto createAddress(@RequestBody AddressDto addressDto) {
        Address address = addressMapper.toEntity(addressDto);
        addressRepository.save(address);
        return addressMapper.toDto(address);
    }

    // Get all Addresses assigned to a User
    @GetMapping("/{userId}")
    public List<AddressDto> getAllAddressesAssignedToUser(@PathVariable Integer userId) {
        List<Address> addressesAssignedUser = addressRepository.findAllByUserId(userId);
        return addressMapper.toDtos(addressesAssignedUser);
    }

    // Update an Address
    @PutMapping("/{id}")
    public ResponseEntity<AddressDto> updateAddress(@PathVariable Integer id, @RequestBody AddressDto addressDto) {
        Optional<Address> address = addressRepository.findById(id);
        if (address.isPresent()) {
            Address existingAddress = addressMapper.partialUpdate(addressDto, address.get());
            Address updatedAddress = addressRepository.save(existingAddress);
            AddressDto updatedAddressDto = addressMapper.toDto(updatedAddress);
            return ResponseEntity.ok(updatedAddressDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an address assigned a user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Integer id) {
        Optional<Address> address = addressRepository.findById(id);
        if (address.isPresent()) {
            addressRepository.delete(address.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
