package com.blog.apllication.service.impl;

import com.blog.apllication.entity.Category;
import com.blog.apllication.payload.CategoryDto;
import com.blog.apllication.repository.CategoryRepo;
import com.blog.apllication.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;



    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category cat = this.modelMapper.map(categoryDto, Category.class);
        Category addedCat = this.categoryRepo.save(cat);
        return this.modelMapper.map(addedCat, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer id) {
        return null;
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        return List.of();
    }

    @Override
    public CategoryDto getCategoryById(Integer id) {
        return null;
    }

    @Override
    public void deleteCategory(Integer id) {

    }
}
