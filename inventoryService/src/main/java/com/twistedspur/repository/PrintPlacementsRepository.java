package com.twistedspur.repository;

import com.twistedspur.entity.PrintPlacement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrintPlacementsRepository extends JpaRepository<PrintPlacement, Integer> {
}
