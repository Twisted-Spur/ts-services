package com.twistedspur.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO for {@link com.twistedspur.entity.ProductSkus}
 */
public record ProductSkusDto(Integer id, @NotNull String sku, @NotNull BigDecimal price, @NotNull BigDecimal cost,
                             @NotNull Integer quantity, Instant createdAt, Instant updatedAt) implements Serializable {
}