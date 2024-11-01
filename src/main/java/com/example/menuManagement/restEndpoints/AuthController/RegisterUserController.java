package com.example.menuManagement.restEndpoints.AuthController;

import com.example.menuManagement.authModel.RegisterUser;
import com.example.menuManagement.model.payload.auth.RegisterUserDto;
import com.example.menuManagement.service.authService.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@ResponseBody
@Controller
@RequestMapping("/api/register")
public class RegisterUserController {
    private RegisterUserService registerUserService;
    @Autowired
    public RegisterUserController(RegisterUserService registerUserService) {
        this.registerUserService = registerUserService;
    }
    @PostMapping("/user")
    public ResponseEntity<RegisterUserDto> register (@RequestBody RegisterUserDto registerUserDto) {
        RegisterUserDto dto = registerUserService.createAUser(registerUserDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @GetMapping("/getUser/{userName}")
    public ResponseEntity<RegisterUserDto> getUser (@PathVariable(value = "userName") String userName) {
        RegisterUserDto dto =registerUserService.findByUserName(userName);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @PutMapping("/modifyUser")
    public ResponseEntity<RegisterUserDto> modifyUserByUserName (@RequestBody RegisterUserDto registerUserDto,
                                                                 @RequestParam(value = "userName") String userName) {
        RegisterUserDto dto = registerUserService.updateUserByName(registerUserDto,userName);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @PutMapping("/modifyByEmail/{email}")
    public ResponseEntity<RegisterUserDto> modifyUserByEmail (@RequestBody RegisterUserDto registerUserDto,
                                                              @PathVariable(value="email") String email){
        RegisterUserDto dto = registerUserService.updateUserByEmail(registerUserDto,email);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @DeleteMapping("/deleteByUserName/{userName}")
    public ResponseEntity<String> deleteUserByUserName (@PathVariable(value = "userName") String userName){
        registerUserService.deleteUserByName(userName);
        String delete = "User has been successfully deleted";
        return new ResponseEntity<>(delete,HttpStatus.OK);
    }
    @DeleteMapping("/deleteByEmail")
    public ResponseEntity<String> deleteByEmail (@RequestParam(value = "email") String email){
        registerUserService.deleteUserByEmail(email);
        String delete = "User has been successfully dleted";
        return new ResponseEntity<>(delete,HttpStatus.OK);
    }
}
