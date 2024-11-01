package com.example.menuManagement.restEndpoints;

import com.example.menuManagement.model.payload.MealCourseDto;
import com.example.menuManagement.model.payload.PaginationAndSortingResponse;
import com.example.menuManagement.service.MealCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/api/order")
public class Endpoints {
    private MealCourseService mealCourseService;
    @Autowired
    public Endpoints(MealCourseService mealCourseService) {
        this.mealCourseService = mealCourseService;
    }
    @PostMapping("/placeOrder")
    public ResponseEntity<MealCourseDto> placeAnOrder (@RequestBody MealCourseDto mealCourseDto){
        MealCourseDto dto = mealCourseService.orderAMeal(mealCourseDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PostMapping("/placeMultipleOrder")
    public ResponseEntity<List<MealCourseDto>> placeMultipleOrder (@RequestBody List<MealCourseDto> mealCourseDtoList){
        List<MealCourseDto> dtos = mealCourseService.orderMultipleMeals(mealCourseDtoList);
        return new ResponseEntity<>(dtos,HttpStatus.CREATED);
    }

    @GetMapping("/mealReady/{id}")
    public ResponseEntity<MealCourseDto> fetchAnOrder (@PathVariable(value = "id") Long id){
       MealCourseDto dto = mealCourseService.recieveMeal(id);
       return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @GetMapping("/allMeals")
    public ResponseEntity<List<MealCourseDto>> fetchAllOrder (){
        List<MealCourseDto> dtos = mealCourseService.receiveMeals();
        return new ResponseEntity<>(dtos,HttpStatus.OK);
    }

    @GetMapping("/mealPages")
    public ResponseEntity<List<MealCourseDto>> pageOfMeals (@RequestParam(value = "pageNo") int pageNo,
                                                            @RequestParam(value="pageSize") int pageSize) {
        List<MealCourseDto> dtos = mealCourseService.fetchPageOfMeals(pageNo,pageSize);
        return new ResponseEntity<>(dtos,HttpStatus.OK);
    }

    @GetMapping("/sortPages")
    public ResponseEntity<List<MealCourseDto>> sortedMealPage (@RequestParam(value="sortDir") String sortDir,
                                                               @RequestParam(value="sortBy") String sortBy) {

        List<MealCourseDto> dtos = mealCourseService.SortedPageOfMeals(sortDir,sortBy);
        return new ResponseEntity<>(dtos,HttpStatus.OK);
    }

    @GetMapping("/customResponse/{pageNumber}/{pageSize}")
    public ResponseEntity<PaginationAndSortingResponse> customResponse (@PathVariable(value = "pageNumber") int pageNumber,
                                                                                @PathVariable(value ="pageSize")int pageSize){
        PaginationAndSortingResponse dtos =  mealCourseService.fetchCustomMealPg(pageNumber,pageSize);
        return new ResponseEntity<>(dtos,HttpStatus.OK);
    }

    @GetMapping("/pages/sorted")
    public ResponseEntity<List<MealCourseDto>> sortedPages (@RequestParam int pageNo,
                                                     @RequestParam int pageSize,
                                                     @RequestParam String sortDir,
                                                     @RequestParam String sortBy){
        List<MealCourseDto> dtos = mealCourseService.fetchSortedMealPages(pageNo,pageSize,sortDir,sortBy);
        return new ResponseEntity<>(dtos,HttpStatus.OK);
    }

    @PutMapping("/modifyOrder/{id}")
    public ResponseEntity<MealCourseDto> updateOrder (@RequestBody MealCourseDto mealCourseDto,
                                                            @PathVariable(value = "id") Long id) {
       MealCourseDto dto = mealCourseService.modifyAnOrder(mealCourseDto,id);
       return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @DeleteMapping("/removeOrder")
    public ResponseEntity<String> deleteAnOrder (@RequestParam(value = "id") Long id) {
        mealCourseService.deleteAnOrder(id);
        return new ResponseEntity<>("Order is successfully deleted",HttpStatus.OK);
    }
}
