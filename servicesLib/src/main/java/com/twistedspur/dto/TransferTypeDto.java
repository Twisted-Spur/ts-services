package com.twistedspur.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.twistedspur.entity.TransferType}
 */
public record TransferTypeDto(Integer id, @NotNull String transferType, Instant createdAt,
                              Instant updatedAt) implements Serializable {
}