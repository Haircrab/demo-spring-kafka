package com.example.demo.model.Jwt;

import lombok.Data;

@Data
public class JwtRequest {
    private String username;
    private String password;
}
