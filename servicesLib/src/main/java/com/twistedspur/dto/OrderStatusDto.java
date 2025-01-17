package com.twistedspur.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.twistedspur.entity.OrderStatus}
 */
public record OrderStatusDto(Integer id, @NotNull String orderStatus, Instant createdAt,
                             Instant updatedAt) implements Serializable {
}