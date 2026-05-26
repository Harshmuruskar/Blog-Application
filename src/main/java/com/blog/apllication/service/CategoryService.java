package com.blog.apllication.service;

import com.blog.apllication.entity.Category;
import com.blog.apllication.payload.CategoryDto;

import java.util.List;

public interface CategoryService {

    public CategoryDto createCategory(CategoryDto categoryDto);
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer id);
    public List<CategoryDto > getAllCategory();
    public CategoryDto getCategoryById(Integer id);
    public void deleteCategory(Integer id);
}
