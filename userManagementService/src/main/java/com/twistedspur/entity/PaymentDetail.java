package com.twistedspur.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "payment_details", schema = "twisted_spur")
public class PaymentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_details_id_gen")
    @SequenceGenerator(name = "payment_details_id_gen", sequenceName = "payment_details_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private OrderDetail order;

    @Column(name = "amount", precision = 12, scale = 2)
    private BigDecimal amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_system")
    private PaymentSystem paymentSystem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_status")
    private PaymentState paymentStatus;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}