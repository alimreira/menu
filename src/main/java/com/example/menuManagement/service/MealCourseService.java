package com.example.menuManagement.service;

import com.example.menuManagement.model.MealCourse;
import com.example.menuManagement.model.payload.MealCourseDto;
import com.example.menuManagement.model.payload.PaginationAndSortingResponse;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface MealCourseService {
     MealCourseDto orderAMeal (MealCourseDto mealCourseDto);

     List<MealCourseDto> orderMultipleMeals (List<MealCourseDto> mealCourseDtos);

     MealCourseDto recieveMeal (Long id);

     List<MealCourseDto> receiveMeals ();

     List<MealCourseDto> fetchPageOfMeals (int pageNo, int pageSize);

     List<MealCourseDto> SortedPageOfMeals (String sortDir,String sortBy);

     PaginationAndSortingResponse fetchCustomMealPg (int pageNo, int pageSize);

     List<MealCourseDto> fetchSortedMealPages (int pageNo, int pageSize,String sortDir,String sortBy);

     MealCourseDto modifyAnOrder (MealCourseDto mealCourseDto, Long id);

     void deleteAnOrder (Long id);


}
