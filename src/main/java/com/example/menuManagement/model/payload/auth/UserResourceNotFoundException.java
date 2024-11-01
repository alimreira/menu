package com.example.menuManagement.model.payload.auth;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@NoArgsConstructor
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private String fieldValue;

    public UserResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
        super("Not found " + resourceName + " " + fieldName + " " + fieldValue);
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
