package com.example.menuManagement.service.authService;

import com.example.menuManagement.authModel.Permission;
import com.example.menuManagement.authModel.Role;
import com.example.menuManagement.repository.authRepository.PermissionRepository;
import com.example.menuManagement.repository.authRepository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService{
    private RoleRepository roleRepository;
    private PermissionRepository permissionRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, PermissionRepository permissionRepository) {
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
    }

    @Override
    public Role createRole(Role role) {
       Role pass = roleRepository.save(role);
        return pass;
    }

    @Override
    public Role getRole(String name) {
        Role sieve = roleRepository.findByName(name).orElseThrow(()-> new RuntimeException());
        return sieve;
    }

    @Override
    public List<Role> getAllRoles() {
        List<Role> roleList = roleRepository.findAll();
        return roleList;
    }

    @Override
    public Role updateARole(Role role, String name) {
      Role sieve =  roleRepository.findByName(name).orElseThrow(()-> new RuntimeException());
      sieve.setName(role.getName());
      Role le = roleRepository.save(sieve);
      return le;
    }

    @Override
    public void deleteARole(String name) {
      Role sieve = roleRepository.findByName(name).orElseThrow(()-> new RuntimeException());
      roleRepository.delete(sieve);
    }

//    @Override
//    public void assignPermissionsToRole(String roleName, List<String> permissionNames) {
//        Role role = roleRepository.findByName(roleName)
//                .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));
//
//        Set<Permission> permissions = permissionNames.stream()
//                .map(permissionName -> new Permission(permissionName))
//                .collect(Collectors.toSet());
//
//        role.setPermissions(permissions);
//        roleRepository.save(role);
//    }
    @Override
    public void createPermissionsForRole(Role role, List<String> permissionNames) {
        List<Permission> permissions = permissionNames.stream()
                .map(permissionName -> new Permission(permissionName))
                .collect(Collectors.toList());

        role.setPermissions(new HashSet<>(permissions));
        roleRepository.save(role);
    }

}