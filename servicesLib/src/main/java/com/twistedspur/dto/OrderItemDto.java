package com.twistedspur.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.twistedspur.entity.OrderItem}
 */
public record OrderItemDto(Integer id, @NotNull Integer productId, @NotNull Integer quantity, String orderItemNotes,
                           Instant createdAt, Instant updatedAt) implements Serializable {
}