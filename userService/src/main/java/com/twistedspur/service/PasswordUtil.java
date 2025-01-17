package com.twistedspur.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordUtil {
    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static String hashPassword(String plainPassword) {
        // BCrypt automatically generates a salt and includes it in the hashed password
        return passwordEncoder.encode(plainPassword);
    }

    public static boolean verifyPassword(String plainPassword, String hashedPassword) {
        // BCrypt automatically extracts the salt from the hashed password and verifies it
        return passwordEncoder.matches(plainPassword, hashedPassword);
    }
}