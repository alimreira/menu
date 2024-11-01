package com.example.menuManagement.service.authService;

import com.example.menuManagement.authModel.RegisterUser;
import com.example.menuManagement.authModel.Role;
import com.example.menuManagement.repository.authRepository.RegisterUserRepository;
import com.example.menuManagement.repository.authRepository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BatchRoleAssignmentService {
    private RegisterUserRepository registerUserRepository;
    private RoleRepository roleRepository;
    @Autowired
    public BatchRoleAssignmentService(RegisterUserRepository registerUserRepository,
                                      RoleRepository roleRepository) {
        this.registerUserRepository = registerUserRepository;
        this.roleRepository = roleRepository;
    }


    public void assignRolesToUsersInBatch () {
        List<RegisterUser> registerUserList = registerUserRepository.findAll();
        List<Role> roleList = roleRepository.findAll();

        //Assign roles to users
        Map<String,Role> rolesByName = roleList.stream().collect(Collectors.toMap(Role::getName, role->role));
        for (RegisterUser user : registerUserList) {
            Set<Role> userRoles = user.getRoleSet();
            userRoles.add(rolesByName.get("ROLE_CUSTOMER"));
            userRoles.add(rolesByName.get("ROLE_CUSTOMER"));
            userRoles.add(rolesByName.get("ROLE_CUSTOMER"));
            }
        registerUserRepository.saveAll(registerUserList);
    }

}
