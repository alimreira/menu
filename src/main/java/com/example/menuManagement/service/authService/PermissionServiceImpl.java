package com.example.menuManagement.service.authService;

import com.example.menuManagement.authModel.Permission;
import com.example.menuManagement.repository.authRepository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PermissionServiceImpl implements PermissionService{
    private PermissionRepository permissionRepository;
    @Autowired
    public PermissionServiceImpl(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Override
    public Permission createPermission(Permission permission) {
       Permission saved =  permissionRepository.save(permission);
        return saved;
    }

    @Override
    public Permission getPermission(String name) {
        Permission permit = permissionRepository.findByName(name).orElseThrow(()-> new RuntimeException());
        return permit;
    }

    @Override
    public List<Permission> getAllPermission() {
         List<Permission> permissionList =permissionRepository.findAll();
            return permissionList;
    }

    @Override
    public Permission updatePermission(Permission permission, String name) {
        Permission permit = permissionRepository.findByName(name).orElseThrow(()-> new RuntimeException());
        permit.setName(permission.getName());
        Permission pr = permissionRepository.save(permit);
        return pr;
    }

    @Override
    public void deletePermission(String name) {
        Permission permit = permissionRepository.findByName(name).orElseThrow(()-> new RuntimeException());
        permissionRepository.delete(permit);
    }
}
