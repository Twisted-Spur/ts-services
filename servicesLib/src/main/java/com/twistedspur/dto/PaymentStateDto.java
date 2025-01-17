package com.twistedspur.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.twistedspur.entity.PaymentState}
 */
public record PaymentStateDto(Integer id, @NotNull String paymentState, Instant createdAt,
                              Instant updatedAt) implements Serializable {
}