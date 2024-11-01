package com.example.menuManagement.security;

import lombok.Data;


public enum AppUsersPermission {
    MENU_READ("menu:read"),
    MENU_WRITE("menu:write"),
    MENU_UPDATE("menu:update"),
    MENU_DELETE("menu:delete");

    private String permission;
    AppUsersPermission(String permission) {
        this.permission = permission;
    }
}
