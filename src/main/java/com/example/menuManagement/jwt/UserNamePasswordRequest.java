package com.example.menuManagement.jwt;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserNamePasswordRequest {
    private String userName;
    private String password;
}
