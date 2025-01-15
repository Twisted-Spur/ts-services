package com.twistedspur.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO for {@link com.twistedspur.entity.Print}
 */
public record PrintDto(@NotNull Integer id,
                       @NotNull Integer categoryId,
                       @NotNull Integer transferTypeId,
                       @NotNull BigDecimal price,
                       @NotNull String urlToPrint,
                       Instant createdAt,
                       Instant updatedAt) implements Serializable {
}