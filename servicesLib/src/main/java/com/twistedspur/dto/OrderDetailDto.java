package com.twistedspur.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO for {@link com.twistedspur.entity.OrderDetail}
 */
public record OrderDetailDto(Integer id, @NotNull BigDecimal total, @NotNull Integer orderStatus,
                             @NotNull String orderNotes, Instant createdAt, Instant updatedAt) implements Serializable {
}