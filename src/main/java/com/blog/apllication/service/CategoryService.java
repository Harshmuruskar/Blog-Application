package com.blog.apllication.service;

import com.blog.apllication.entity.Category;
import com.blog.apllication.payload.CategoryDto;

import java.util.List;

public interface CategoryService {

    public CategoryDto createCategory(CategoryDto categoryDto);
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
    public List<CategoryDto > getAllCategory();
    public CategoryDto getCategoryById(Integer categoryId);
    void deleteCategory(Integer categoryId);
}
