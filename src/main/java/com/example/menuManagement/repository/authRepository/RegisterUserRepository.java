package com.example.menuManagement.repository.authRepository;

import com.example.menuManagement.authModel.RegisterUser;
import com.example.menuManagement.model.payload.auth.RegisterUserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisterUserRepository extends JpaRepository<RegisterUser,Long> {

    Optional<RegisterUser> findByEmail (String email);
    Optional<RegisterUser> findByUserName(String userName);

    Boolean existsByUserName (String userName);

    Boolean existsByEmail (String email);
}
