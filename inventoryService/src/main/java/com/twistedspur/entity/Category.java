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
@Table(name = "categories", schema = "twisted_spur")
public class Category {
    @Id
    @ColumnDefault("nextval('twisted_spur.categories_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "category", length = Integer.MAX_VALUE)
    private String category;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}