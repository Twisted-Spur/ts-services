package com.twistedspur.controller;

import com.twistedspur.dto.AddressDto;
import com.twistedspur.service.AddressService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@Tag(name = "Address Management", description = "Operations to perform address management")
public class AddressController {

    @Autowired
    AddressService addressService;

    // Create a new Address
    @PostMapping
    public AddressDto createAddress(@RequestBody AddressDto addressDto) {
        return addressService.createAddress(addressDto);
    }

    // Get all Addresses assigned to a User
    @GetMapping("/{userId}")
    public List<AddressDto> getAllAddressesAssignedToUser(@PathVariable Integer userId) {
        return addressService.getAllAddressesAssignedToUser(userId);
    }

    // Update an Address
    @PutMapping("/{id}")
    public AddressDto updateAddress(@PathVariable Integer id, @RequestBody AddressDto addressDto) {
        return addressService.updateAddress(id, addressDto);
    }

    // Delete an address assigned a user
    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Integer id) {
        addressService.deleteAddress(id);
    }
}
