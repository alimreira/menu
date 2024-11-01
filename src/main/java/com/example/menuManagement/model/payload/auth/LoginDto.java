package com.example.menuManagement.model.payload.auth;

import lombok.Data;

@Data
public class LoginDto {
    private String username;
    private String password;
}
