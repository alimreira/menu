package com.example.menuManagement.model.payload.auth;

import lombok.Data;

@Data
public class RegisterUserDto {
    private Long id;
    private String name;
//    @Column(unique = true)
    private String userName;
//    @Column(unique = true)
    private String email;
    private String password;
}
