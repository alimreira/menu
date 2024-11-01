package com.example.menuManagement.repository;

import com.example.menuManagement.model.MealCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealCourseRepository extends JpaRepository<MealCourse,Long> {
}
