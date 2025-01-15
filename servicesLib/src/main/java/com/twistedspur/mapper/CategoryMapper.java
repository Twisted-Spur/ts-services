package com.twistedspur.mapper;

import com.twistedspur.dto.CategoryDto;
import com.twistedspur.entity.Category;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {
    Category toEntity(CategoryDto categoryDto);

    CategoryDto toDto(Category category);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Category partialUpdate(CategoryDto categoryDto, @MappingTarget Category category);

    default Category mapCategoryIdToCategory(Integer catId) {
        if (catId == null) {
            return null;
        }
        Category category = new Category();
        category.setId(catId);
        return category;
    }

    default Integer mapCategoryToIntegerId(Category category) {
        return category == null ? null : category.getId();
    }
}