package com.twistedspur.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.twistedspur.entity.CartItem}
 */
public record CartItemDto(Integer id, @NotNull Integer quantity, Instant createdAt,
                          Instant updatedAt) implements Serializable {
}