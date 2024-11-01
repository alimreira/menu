package com.example.menuManagement.restEndpoints.AuthController;

import com.example.menuManagement.authModel.Permission;
import com.example.menuManagement.service.authService.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResponseBody
@Controller
@RequestMapping("/api/permit")
public class PermissionController {
    private PermissionService permissionService;
    @Autowired
    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }
    @PostMapping("/create")
    public ResponseEntity<Permission> createPermission (@RequestBody Permission permission){
       Permission permit =  permissionService.createPermission(permission);
       return new ResponseEntity<>(permit, HttpStatus.CREATED);
    }
    @GetMapping("/fetch/{name}")
    public ResponseEntity<Permission> fetchPermission (@PathVariable(value = "name") String name){
        Permission permit = permissionService.getPermission(name);
        return new ResponseEntity<>(permit,HttpStatus.OK);
    }
    @GetMapping("/fetchAll")
    public ResponseEntity<List<Permission>> fetchAll (){
        List<Permission> permit = permissionService.getAllPermission();
        return new ResponseEntity<>(permit,HttpStatus.OK);
    }
    @PutMapping("/modify")
    public ResponseEntity<Permission> modify (Permission permission, String name){
        Permission permit = permissionService.updatePermission(permission,name);
        return new ResponseEntity<>(permit,HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> delete (@RequestParam(value ="name") String name) {
        permissionService.deletePermission(name);
        String delete = "User has been successfully deleted";
        return new ResponseEntity<>(delete,HttpStatus.OK);
    }
}
