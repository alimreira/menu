package com.example.menuManagement.service;

import com.example.menuManagement.model.MealCourse;
import com.example.menuManagement.model.payload.MealCourseDto;
import com.example.menuManagement.model.payload.PaginationAndSortingResponse;
import com.example.menuManagement.model.payload.ResourceNotFoundException;
import com.example.menuManagement.repository.MealCourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MealCourseServiceImpl implements MealCourseService{

    private MealCourseRepository mealCourseRepository;
    private ModelMapper modelMapper;
    private PaginationAndSortingResponse paginationAndSortingResponse;

    @Autowired
    public MealCourseServiceImpl(MealCourseRepository mealCourseRepository,
                                 ModelMapper modelMapper,
                                 PaginationAndSortingResponse paginationAndSortingResponse) {
        this.mealCourseRepository = mealCourseRepository;
        this.modelMapper = modelMapper;
        this.paginationAndSortingResponse = paginationAndSortingResponse;
    }

    @Override
    public MealCourseDto orderAMeal(MealCourseDto mealCourseDto) {
        MealCourse meal = modelMapper.map(mealCourseDto, MealCourse.class);
        MealCourse placedOrder = mealCourseRepository.save(meal);
        return modelMapper.map(placedOrder,MealCourseDto.class);
    }

    @Override
    public List<MealCourseDto> orderMultipleMeals(List<MealCourseDto> mealCourseDtos) {
        List<MealCourse> mealCourses = mealCourseDtos.stream()
                .map((meal)-> modelMapper.map(meal,MealCourse.class))
                .collect(Collectors.toList());
        List<MealCourse> savedMeals = mealCourseRepository.saveAll(mealCourses);
        List<MealCourseDto> dtos = savedMeals.stream().map((sm)->modelMapper.map(sm,MealCourseDto.class)).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public MealCourseDto recieveMeal(Long id) {
        MealCourse meal = mealCourseRepository
                .findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("MealCourse","id",id));
        MealCourseDto dto =modelMapper.map(meal,MealCourseDto.class);
        return dto;
    }

    @Override
    public List<MealCourseDto> receiveMeals() {
        List<MealCourse> meal = mealCourseRepository.findAll();
        List<MealCourseDto> dtos = meal.stream().map((m)-> modelMapper
                .map(m,MealCourseDto.class))
                .collect(Collectors.toList());
        return dtos;
    }

    @Override
    public List<MealCourseDto> fetchPageOfMeals(int pageNo, int pageSize) {
        Page<MealCourse> page = mealCourseRepository.findAll(PageRequest.of(pageNo,pageSize));
        List<MealCourse> mealCourses = page.getContent();
        List<MealCourseDto> dtos = mealCourses.stream()
                .map((mealCourse)-> modelMapper.map(mealCourse,MealCourseDto.class))
                .collect(Collectors.toList());
        return dtos;
    }

    @Override
    public  List<MealCourseDto> SortedPageOfMeals(String sortDir,String sortBy) {
        List<MealCourse> mealCourses = mealCourseRepository.findAll(Sort.by(Sort.Direction.fromString(sortDir),sortBy));
        return mealCourses.stream()
                .map((meal)-> modelMapper.map(meal,MealCourseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PaginationAndSortingResponse fetchCustomMealPg(int pageNo, int pageSize) {
       Page<MealCourse> mealCourses = mealCourseRepository.findAll(PageRequest.of(pageNo,pageSize));
       List<MealCourse> mealCourses1 = mealCourses.getContent();
       List<MealCourseDto> dtos = mealCourses1.stream().map((meal)-> modelMapper.map(meal,MealCourseDto.class)).collect(Collectors.toList());
       paginationAndSortingResponse.setContent(mealCourses.getContent());
       paginationAndSortingResponse.setPageNo(mealCourses.getNumber());
       paginationAndSortingResponse.setPageSize(mealCourses.getSize());
       paginationAndSortingResponse.setTotalElements(mealCourses.getTotalElements());
       paginationAndSortingResponse.setTotalPages(mealCourses.getTotalPages());
       paginationAndSortingResponse.setFirst(mealCourses.isFirst());
       paginationAndSortingResponse.setLast(mealCourses.isLast());
        return paginationAndSortingResponse;
    }

    @Override
    public  List<MealCourseDto> fetchSortedMealPages(int pageNo, int pageSize,String sortDir,String sortBy) {
        Page<MealCourse> meals = mealCourseRepository.findAll(PageRequest.of(pageNo,pageSize,Sort.by(Sort.Direction.fromString(sortDir),sortBy)));
        return meals.stream().map((m)-> modelMapper.map(m,MealCourseDto.class)).collect(Collectors.toList());
    }

    @Override
    public MealCourseDto modifyAnOrder(MealCourseDto mealCourseDto, Long id) {
        MealCourse mealCourse = mealCourseRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("MealCourse","id",id));
//        MealCourse meal = modelMapper.map(mealCourseDto,MealCourse.class);
        mealCourse.setCourseName(mealCourse.getCourseName());
        mealCourse.setClassOfFood(mealCourse.getClassOfFood());
        mealCourse.setCostPerDish(mealCourse.getCostPerDish());
        mealCourse.setSideDish(mealCourse.getSideDish());
        mealCourse.setSpoonsPerDish(mealCourse.getSpoonsPerDish());
        MealCourse savedMeal = mealCourseRepository.save(mealCourse);
        return modelMapper.map(mealCourse,MealCourseDto.class);
    }

    @Override
    public void deleteAnOrder(Long id) {
       MealCourse mealCourse = mealCourseRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("MealCourse","id",id));
       mealCourseRepository.deleteById(id);
    }
}
