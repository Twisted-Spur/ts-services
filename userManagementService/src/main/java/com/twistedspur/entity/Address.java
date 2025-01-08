package com.twistedspur.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "addresses", schema = "twisted_spur")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addresses_id_gen")
    @SequenceGenerator(name = "addresses_id_gen", sequenceName = "addresses_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "title", length = Integer.MAX_VALUE)
    private String title;

    @Column(name = "billing_address", length = Integer.MAX_VALUE)
    private String billingAddress;

    @Column(name = "shipping_address", length = Integer.MAX_VALUE)
    private String shippingAddress;

    @Column(name = "country", length = Integer.MAX_VALUE)
    private String country;

    @Column(name = "state_short", length = Integer.MAX_VALUE)
    private String stateShort;

    @Column(name = "city", length = Integer.MAX_VALUE)
    private String city;

    @Column(name = "postal_code", length = Integer.MAX_VALUE)
    private String postalCode;

    @Column(name = "phone_number", length = Integer.MAX_VALUE)
    private String phoneNumber;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}