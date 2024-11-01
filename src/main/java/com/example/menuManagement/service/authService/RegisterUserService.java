package com.example.menuManagement.service.authService;

import com.example.menuManagement.model.payload.auth.RegisterUserDto;

public interface RegisterUserService {
         RegisterUserDto createAUser (RegisterUserDto registerDto);

         RegisterUserDto findByUserName (String userName);

         RegisterUserDto updateUserByName (RegisterUserDto registerDto, String userName);

         RegisterUserDto updateUserByEmail (RegisterUserDto registerDto, String email);

         void deleteUserByName (String userName);

         void deleteUserByEmail (String email);
}
