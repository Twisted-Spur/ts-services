package com.twistedspur.service;

import com.twistedspur.dto.CategoryDto;
import com.twistedspur.exception.UserValidationException;
import com.twistedspur.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {

    @Autowired
    CategoriesRepository categoriesRepository;

    public List<CategoryDto> createCategories(List<CategoryDto> categoryDtos) {
        if (categoriesRepository.existsByEmail(user.getEmail())) {
            throw new UserValidationException("Sorry, an account with that email already exists.");
        }

        // need to secure the password before db storage
        user.setPasswd(PasswordUtil.hashPassword(user.getPasswd()));

        userRepository.save(user);
        return userMapper.toDto(user);
    }
}
