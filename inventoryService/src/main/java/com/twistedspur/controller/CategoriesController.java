package com.twistedspur.controller;

import com.twistedspur.dto.CategoryDto;
import com.twistedspur.mapper.CategoryMapperImpl;
import com.twistedspur.service.CategoriesService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
@Tag(name = "Category Management", description = "Operations to perform category management")
public class CategoriesController {

        @Autowired
        CategoriesService categoriesService;

        // Create a new categories
        @PostMapping
        public List<CategoryDto> createCategories(@RequestBody List<CategoryDto> categoryDtos) {
            return categoriesService.createCategories(categoryDtos);
        }

        // Get all Categories
        @GetMapping
        public List<CategoryDto> getAllUsers() {
            return categoriesService.getAllCategories();
        }

        // Get a single category by its id
        @GetMapping("/{id}")
        public CategoryDto getCategoryById(@PathVariable Integer id) {
            return categoriesService.getCategoryById(id);
        }

        // Update a category
        @PutMapping("/{id}")
        public CategoryDto updateCategory(@PathVariable Integer id, @RequestBody String updatedCategoryName) {
            return categoriesService.updateCategory(id, updatedCategoryName);
        }

        // Delete a Category
        @DeleteMapping("/{id}")
        public void deleteUser(@PathVariable Integer id) {
            categoriesService.deleteCategory(id);
        }
}
