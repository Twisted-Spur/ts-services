package com.twistedspur.repository;

import com.twistedspur.entity.Print;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrintsRepository extends JpaRepository<Print, Integer> {
}
