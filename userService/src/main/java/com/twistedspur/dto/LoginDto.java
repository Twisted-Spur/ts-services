package com.twistedspur.dto;

import java.io.Serializable;

public record LoginDto (String email, String password) implements Serializable {}
