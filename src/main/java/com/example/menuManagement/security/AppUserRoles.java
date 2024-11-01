package com.example.menuManagement.security;

import com.google.common.collect.Sets;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public enum AppUserRoles {
    CUSTOMER(Sets.newHashSet(AppUsersPermission.MENU_WRITE,AppUsersPermission.MENU_UPDATE,AppUsersPermission.MENU_DELETE)),
    CHEF(Sets.newHashSet(AppUsersPermission.MENU_READ)),
    WAITER(Sets.newHashSet(AppUsersPermission.MENU_READ));

    private Set<AppUsersPermission> permissionSet = new HashSet<>();

    AppUserRoles(Set<AppUsersPermission> permissionSet) {
        this.permissionSet = permissionSet;
    }

    public Set<GrantedAuthority> grantedAuthorities () {
        Set<GrantedAuthority> grantedAuthorities = permissionSet.stream().map((permission)->
                new SimpleGrantedAuthority(permission.name()))
                .collect(Collectors.toSet());
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+ this.name()));
        return grantedAuthorities;
    }
}
