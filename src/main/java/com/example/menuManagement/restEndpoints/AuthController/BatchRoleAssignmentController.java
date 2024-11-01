package com.example.menuManagement.restEndpoints.AuthController;

import com.example.menuManagement.service.authService.BatchRoleAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/batch-role-assignment")
public class BatchRoleAssignmentController {

    @Autowired
    private BatchRoleAssignmentService batchRoleAssignmentService;

    @PostMapping("/assign-roles")
    public ResponseEntity<String> assignRolesToUsers() {
        batchRoleAssignmentService.assignRolesToUsersInBatch();
        return ResponseEntity.ok("Roles assigned in batch successfully.");
    }
}
