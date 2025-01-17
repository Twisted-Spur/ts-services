package com.twistedspur.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.twistedspur.entity.PaymentSystem}
 */
public record PaymentSystemDto(Integer id, @NotNull String paymentSystem, Instant createdAt,
                               Instant updatedAt) implements Serializable {
}