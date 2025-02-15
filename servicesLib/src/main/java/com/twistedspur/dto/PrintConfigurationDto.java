package com.twistedspur.dto;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.twistedspur.entity.PrintConfiguration}
 */
public record PrintConfigurationDto(Integer id,
                                    Integer printPlacementId,
                                    Integer printId,
                                    Integer cartItemId,
                                    Instant createdAt,
                                    Instant updatedAt) implements Serializable {
}