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
@Table(name = "order_details", schema = "twisted_spur")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_details_id_gen")
    @SequenceGenerator(name = "order_details_id_gen", sequenceName = "order_details_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private PaymentDetail payment;

    @Column(name = "total", precision = 12, scale = 2)
    private BigDecimal total;

    @Column(name = "order_status")
    private Integer orderStatus;

    @Column(name = "order_notes", length = Integer.MAX_VALUE)
    private String orderNotes;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}