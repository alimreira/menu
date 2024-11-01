package com.example.menuManagement.service.authService;

import com.example.menuManagement.authModel.RegisterUser;
import com.example.menuManagement.model.payload.ResourceNotFoundException;
import com.example.menuManagement.model.payload.auth.RegisterUserDto;
import com.example.menuManagement.model.payload.auth.UserResourceNotFoundException;
import com.example.menuManagement.repository.authRepository.RegisterUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserServiceImpl implements RegisterUserService{
    private RegisterUserRepository registerUserRepository;
    private ModelMapper modelMapper;
    @Autowired
    public RegisterUserServiceImpl(RegisterUserRepository registerUserRepository, ModelMapper modelMapper) {
        this.registerUserRepository = registerUserRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public RegisterUserDto createAUser(RegisterUserDto registerDto) {
        RegisterUser registerUser = modelMapper.map(registerDto, RegisterUser.class);
        RegisterUser savedUser = registerUserRepository.save(registerUser);
        RegisterUserDto dto = modelMapper.map(savedUser,RegisterUserDto.class);
        return dto;
    }

    @Override
    public RegisterUserDto findByUserName(String userName) {
        RegisterUser user = registerUserRepository.findByUserName(userName).orElseThrow(()-> new UserResourceNotFoundException("RegisterUser","userName",userName));
        RegisterUserDto dto = modelMapper.map(user,RegisterUserDto.class);
        return dto;
    }

    @Override
    public RegisterUserDto updateUserByName(RegisterUserDto registerDto, String userName) {
        RegisterUser user = registerUserRepository.findByUserName(userName).orElseThrow(()->new UserResourceNotFoundException("RegisterUser","userName",userName));
        RegisterUser user1 = modelMapper.map(registerDto,RegisterUser.class);
        user.setName(user1.getName());
        user.setUserName(user1.getUserName());
        user.setEmail(user1.getEmail());
        user.setName(user1.getPassword());
        RegisterUser modified = registerUserRepository.save(user);
        RegisterUserDto dto = modelMapper.map(modified,RegisterUserDto.class);
        return dto;
    }

    @Override
    public RegisterUserDto updateUserByEmail(RegisterUserDto registerDto, String email) {
       RegisterUser user = registerUserRepository.findByEmail(email).orElseThrow(()->new UserResourceNotFoundException("RegisterUser","email",email));
       RegisterUser user1 = modelMapper.map(registerDto,RegisterUser.class);
       user.setName(user1.getName());
       user.setUserName(user1.getUserName());
       user.setEmail(user1.getEmail());
       user.setPassword(user1.getPassword());
       RegisterUser modified = registerUserRepository.save(user);
       RegisterUserDto dto = modelMapper.map(modified,RegisterUserDto.class);
        return dto;
    }

    @Override
    public void deleteUserByName(String userName) {
       RegisterUser user = registerUserRepository.findByUserName(userName).orElseThrow(()-> new UserResourceNotFoundException("RegisterUser","userName",userName));
       registerUserRepository.delete(user);
    }

    @Override
    public void deleteUserByEmail(String email) {
        RegisterUser user =registerUserRepository.findByEmail(email).orElseThrow(()-> new UserResourceNotFoundException("RegisterUser","email",email));
        registerUserRepository.delete(user);
    }
}
