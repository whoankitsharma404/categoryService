package com.example.categoryService.controller;

import com.example.categoryService.dto.CategoryDTO;
import com.example.categoryService.entity.Category;
import com.example.categoryService.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/admin")
    public String adminHome(){
        return "adminHome";
    }


    @GetMapping("/admin/categories")
    public String getCategories(Model model){
        model.addAttribute("categories",categoryService.getAllCategory());
        return "categories";
    }

    @GetMapping("/admin/categories/add")
    public String addCategories(Model model){
        model.addAttribute("category",new Category());
        return "categoriesAdd";
    }

    @PostMapping("/admin/categories/add")
    public String postCatAdd(@ModelAttribute("category") Category category){
        categoryService.addCategories(category);
        return "redirect:/admin/categories";

    }

    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCat(@PathVariable int id){
        categoryService.deleteCategoryById(id);
        return "redirect:/admin/categories";

    }
    @GetMapping("/admin/categories/update/{id}")
    public String updateCat(@PathVariable int id,Model model){
        Optional<CategoryDTO> category=categoryService.getCategoryById(id);
        if(category.isPresent()){
            model.addAttribute("category",category.get());
            return "categoriesAdd";
        }
        else{
            return "404";
        }
    }

}
