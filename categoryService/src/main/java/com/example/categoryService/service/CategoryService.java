package com.example.categoryService.service;


import com.example.categoryService.dto.CategoryDTO;
import com.example.categoryService.entity.Category;
import com.example.categoryService.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;

    public void addCategories(Category category){
        categoryRepository.save(category);
    }

    public List<CategoryDTO> getAllCategory(){
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());
    }

    public void deleteCategoryById(int id){
        categoryRepository.deleteById(id);
    }


    public Optional<CategoryDTO> getCategoryById(int id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.map(cat -> modelMapper.map(cat, CategoryDTO.class));
    }


}
