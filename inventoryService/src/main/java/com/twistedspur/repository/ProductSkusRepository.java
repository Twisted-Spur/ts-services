package com.twistedspur.repository;

import com.twistedspur.entity.ProductSkus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSkusRepository extends JpaRepository<ProductSkus, Integer> {
}
