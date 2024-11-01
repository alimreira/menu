package com.example.menuManagement.model.payload;


import com.example.menuManagement.model.MealCourse;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
@Data
@Component
public class PaginationAndSortingResponse {
    private List<MealCourse> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean isLast;
    private boolean isFirst;
}
