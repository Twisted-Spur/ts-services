package com.twistedspur.repository;

import com.twistedspur.entity.SkuAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkuAttributesRepository extends JpaRepository<SkuAttribute, Integer> {
}
