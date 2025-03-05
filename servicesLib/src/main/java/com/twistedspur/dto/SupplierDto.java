package com.twistedspur.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.twistedspur.entity.Supplier}
 */
public record SupplierDto(Integer id, @NotNull String supplierName, Instant createdAt,
                          Instant updatedAt) implements Serializable {
}