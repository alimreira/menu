package com.example.menuManagement.service.authService;

import com.example.menuManagement.authModel.Role;

import java.util.List;

public interface RoleService {
    Role createRole (Role role);

    Role getRole (String name);

    List<Role> getAllRoles ();

    Role updateARole (Role role, String name);

    void deleteARole (String name);

    public void createPermissionsForRole(Role role, List<String> permissionNames);

}
