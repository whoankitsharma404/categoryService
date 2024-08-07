package com.example.categoryService.controller;


import com.example.categoryService.dto.CategoryDTO;
import com.example.categoryService.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class CategoryControllerRestCalls {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<CategoryDTO> getAllCategory() {
        return categoryService.getAllCategory();
    }
    @GetMapping("/categories/{id}")
    public Optional<CategoryDTO> getCategoryById(@PathVariable("id") int id){

        return categoryService.getCategoryById(id);

    }

}
