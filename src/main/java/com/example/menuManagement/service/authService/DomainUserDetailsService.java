package com.example.menuManagement.service.authService;

import com.example.menuManagement.authModel.RegisterUser;
import com.example.menuManagement.authModel.Role;
import com.example.menuManagement.model.payload.auth.UserResourceNotFoundException;
import com.example.menuManagement.repository.authRepository.RegisterUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component("userDetailsService")
public class DomainUserDetailsService implements UserDetailsService {

    private final RegisterUserRepository registerUserRepository;

    public DomainUserDetailsService(RegisterUserRepository registerUserRepository) {
        this.registerUserRepository = registerUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        RegisterUser registerUser = registerUserRepository.findByUserName(username)
                .orElseThrow(()-> new UserResourceNotFoundException());
        Set<Role> roleSet = registerUser.getRoleSet();
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = roleSet.stream()
                .map(Role::getName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return new User(registerUser.getUserName(),registerUser.getPassword(),simpleGrantedAuthorities);
    }
}
