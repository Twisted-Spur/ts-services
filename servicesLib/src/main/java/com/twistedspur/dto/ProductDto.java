package com.twistedspur.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO for {@link com.twistedspur.entity.Product}
 */
public record ProductDto(Integer id,
                         @NotNull Integer categoryId,
                         @NotNull BigDecimal price,
                         @NotNull BigDecimal cost,
                         @NotNull Integer quantity,
                         Instant createdAt,
                         Instant updatedAt) implements Serializable {
  }