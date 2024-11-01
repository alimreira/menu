package com.example.menuManagement.model.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MealCourseDto {
    private Long id;
    private String courseName;
    private String classOfFood;
    private float costPerDish;
    private String sideDish;
    private int spoonsPerDish;
}
