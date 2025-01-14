package com.twistedspur.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "payment_systems", schema = "twisted_spur")
public class PaymentSystem {
    @Id
    @ColumnDefault("nextval('twisted_spur.payment_systems_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "payment_system", length = Integer.MAX_VALUE)
    private String paymentSystem;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}