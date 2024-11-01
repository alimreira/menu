package com.example.menuManagement.service.authService;

import com.example.menuManagement.authModel.Permission;

import java.util.List;

public interface PermissionService {
    Permission createPermission (Permission permission);

    Permission getPermission (String name);

    List<Permission> getAllPermission ();

    Permission updatePermission (Permission permission, String name);

    void deletePermission (String name);

}
