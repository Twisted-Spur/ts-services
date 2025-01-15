package com.twistedspur.dto;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.twistedspur.entity.Address}
 */
public record AddressDto(Integer id, @NotBlank Integer userId, @NotBlank String title, @NotBlank String billingAddress,
                         @NotBlank String shippingAddress, @NotBlank String country, @NotBlank String stateShort,
                         @NotBlank String city, @NotBlank String postalCode, @NotBlank String phoneNumber,
                         Instant createdAt, Instant updatedAt) implements Serializable {
}