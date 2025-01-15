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
@Table(name = "order_statuses", schema = "twisted_spur")
public class OrderStatus {
    @Id
    @ColumnDefault("nextval('twisted_spur.order_statuses_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "order_status", length = Integer.MAX_VALUE)
    private String orderStatus;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}