package com.twistedspur.dto;

import java.io.Serializable;

public record LoginRequest (String email, String password) implements Serializable {}
