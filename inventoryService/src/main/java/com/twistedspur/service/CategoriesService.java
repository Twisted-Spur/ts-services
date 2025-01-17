package com.twistedspur.service;

import com.twistedspur.dto.CategoryDto;
import com.twistedspur.entity.Category;
import com.twistedspur.exception.NotFoundException;
import com.twistedspur.mapper.CategoryMapper;
import com.twistedspur.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesService {

    @Autowired
    CategoriesRepository categoriesRepository;

    @Autowired
    CategoryMapper categoryMapper;

    public List<CategoryDto> createCategories(List<CategoryDto> categoryDtos) {
        List<Category> categories = categoryMapper.toEntity(categoryDtos);
        categoriesRepository.saveAll(categories);
        return categoryDtos;
    }

    public List<CategoryDto> getAllCategories() {
        return categoryMapper.toDto(categoriesRepository.findAll());
    }

    public CategoryDto getCategoryById(@PathVariable Integer id) {
        Optional<Category> category = categoriesRepository.findById(id);
        if (category.isEmpty()) {
            throw new NotFoundException("Category with id " + id + " not found");
        }
        return categoryMapper.toDto(category.get());
    }

    public CategoryDto updateCategory(@PathVariable Integer id, @RequestBody String updatedCategoryName) {
        Optional<Category> optCategory = categoriesRepository.findById(id);

        if (optCategory.isEmpty()) {
            throw new NotFoundException("Category with id " + id + " not found");
        }

        Category category = optCategory.get();
        category.setCategory(updatedCategoryName);
        categoriesRepository.save(category);
        return categoryMapper.toDto(category);
    }

    public void deleteCategory(@PathVariable Integer id) {
        categoriesRepository.deleteById(id);
    }
}
