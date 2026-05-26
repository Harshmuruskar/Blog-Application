package com.blog.apllication.repository;

import com.blog.apllication.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category ,Integer> {
}
