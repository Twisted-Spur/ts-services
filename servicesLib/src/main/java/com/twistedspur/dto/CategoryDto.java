package com.twistedspur.dto;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.twistedspur.entity.Category}
 */
public record CategoryDto(
        Integer id,
        String category,
        Instant createdAt,
        Instant updatedAt) implements Serializable {
}