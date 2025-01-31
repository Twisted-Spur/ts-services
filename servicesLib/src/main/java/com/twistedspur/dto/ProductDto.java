package com.twistedspur.dto;

import com.twistedspur.entity.Product;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link Product}
 */
public record ProductDto(Integer id, @NotNull Integer categoryId, @NotNull String name, String summary, String description, Instant createdAt,
                         Instant updatedAt) implements Serializable {
}