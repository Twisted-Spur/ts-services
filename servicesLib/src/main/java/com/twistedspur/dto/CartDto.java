package com.twistedspur.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO for {@link com.twistedspur.entity.Cart}
 */
public record CartDto(Integer id, @NotNull BigDecimal total, Instant createdAt,
                      Instant updatedAt) implements Serializable {
}