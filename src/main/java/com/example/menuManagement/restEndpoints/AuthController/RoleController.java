package com.example.menuManagement.restEndpoints.AuthController;

import com.example.menuManagement.authModel.Role;
import com.example.menuManagement.service.authService.RoleService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@ResponseBody
@Controller
@RequestMapping("/api/role")
public class RoleController {
    private RoleService roleService;
    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
    @PostMapping("/create")
    public ResponseEntity<Role> createRole (@RequestBody Role role){
       Role create =  roleService.createRole(role);
       return new ResponseEntity<Role>(create, HttpStatus.CREATED);
    };
    @GetMapping("/fetch")
    public ResponseEntity<Role> fetchRole (@RequestParam(value = "name") String name){
       Role fetch = roleService.getRole(name);
       return new ResponseEntity<>(fetch,HttpStatus.OK);
    }
    @GetMapping("/fetchAll")
    public ResponseEntity<List<Role>> allRoles (){
       List<Role> all =  roleService.getAllRoles();
       return new ResponseEntity<>(all,HttpStatus.OK);
    }
    @PutMapping("/modify/{name}")
    public ResponseEntity<Role> updateRole (@RequestBody Role role, @PathVariable(value ="name") String name) {
        Role rl = roleService.updateARole(role,name);
        return new ResponseEntity<>(rl,HttpStatus.OK);
    }
    @DeleteMapping("/remove")
    public ResponseEntity<String> deleteRole (@RequestParam(value = "name") String name){
        roleService.deleteARole(name);
        String delete = "Role is successfully deleted";
        return new ResponseEntity<>(delete,HttpStatus.OK);
    }

//    @PostMapping("/assignPermissions")
//    public ResponseEntity<String> assignPermissionsToRole(
//            @RequestParam(value = "roleName") String roleName,
//            @RequestBody String requestJson) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            List<String> permissions = objectMapper.readValue(requestJson, new TypeReference<List<String>>() {});
//            roleService.assignPermissionsToRole(roleName, permissions);
//            String response = "Permissions assigned to role: " + roleName;
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (IOException e) {
//            // Handle JSON parsing error
//            return new ResponseEntity<>("JSON parsing error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }

    @PostMapping("/{roleName}/permissions")
    public ResponseEntity<String> createPermissionsForRole(@PathVariable String roleName,
                                                            @RequestBody List<String> permissionNames) {
        Role role = roleService.getRole(roleName);
        roleService.createPermissionsForRole(role, permissionNames);

        String response = "Permissions created for role: " + roleName;
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
