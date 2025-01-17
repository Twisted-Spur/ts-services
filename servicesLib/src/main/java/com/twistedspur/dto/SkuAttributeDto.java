package com.twistedspur.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.twistedspur.entity.SkuAttribute}
 */
public record SkuAttributeDto(Integer id, @NotNull String attributeType, @NotNull String attributeValue,
                              Instant createdAt, Instant updatedAt) implements Serializable {
}