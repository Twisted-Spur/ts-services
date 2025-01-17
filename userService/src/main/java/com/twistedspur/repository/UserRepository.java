package com.twistedspur.repository;

import com.twistedspur.entity.User;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByEmail(@NotNull String email);

    Optional<User> findByEmail(@NotNull String email);
}
