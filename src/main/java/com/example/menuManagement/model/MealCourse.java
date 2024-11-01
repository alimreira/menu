package com.example.menuManagement.model;

import lombok.Data;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Data
@Entity
@Table(name = "meal")
public class MealCourse {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name ="course_name", nullable = false)
        private String courseName;

        @Column(name ="food_class")
        private String classOfFood;
        @Column(name = "meal_cost")
        private float costPerDish;
        @Column(name = "side_dish")
        private String sideDish;
        @Column(name= "spoon_servings")
        private int spoonsPerDish;
}
