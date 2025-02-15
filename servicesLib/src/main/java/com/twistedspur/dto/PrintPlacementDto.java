package com.twistedspur.dto;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.twistedspur.entity.PrintPlacement}
 */
public record PrintPlacementDto(Integer id,
                                Integer categoryId,
                                String placement,
                                Instant createdAt,
                                Instant updatedAt) implements Serializable {
}