package com.twistedspur.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO for {@link com.twistedspur.entity.PaymentDetail}
 */
public record PaymentDetailDto(Integer id, @NotNull BigDecimal amount, Instant createdAt,
                               Instant updatedAt) implements Serializable {
}