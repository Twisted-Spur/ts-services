package com.twistedspur.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.twistedspur.entity.Supplier}
 */
public record SupplierDto(Integer id, @NotNull String brand, Instant createdAt,
                          Instant updatedAt) implements Serializable {
}