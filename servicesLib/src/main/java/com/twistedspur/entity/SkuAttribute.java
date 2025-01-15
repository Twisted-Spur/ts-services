package com.twistedspur.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "sku_attributes", schema = "twisted_spur")
public class SkuAttribute {
    @Id
    @ColumnDefault("nextval('twisted_spur.sku_attributes_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_sku_id")
    private ProductSkus productSku;

    @NotNull
    @Column(name = "attribute_type", nullable = false, length = Integer.MAX_VALUE)
    private String attributeType;

    @NotNull
    @Column(name = "attribute_value", nullable = false, length = Integer.MAX_VALUE)
    private String attributeValue;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}