package com.twistedspur.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "product_skus", schema = "twisted_spur")
public class ProductSkus {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_skus_id_gen")
    @SequenceGenerator(name = "product_skus_id_gen", sequenceName = "product_skus_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "print_id", nullable = false)
    private Print print;

    @Column(name = "sku", length = Integer.MAX_VALUE)
    private String sku;

    @Column(name = "price", precision = 12, scale = 2)
    private BigDecimal price;

    @Column(name = "cost", precision = 12, scale = 2)
    private BigDecimal cost;

    @Column(name = "quantity")
    private Integer quantity;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}