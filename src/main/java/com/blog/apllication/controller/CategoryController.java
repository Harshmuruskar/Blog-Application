package com.blog.apllication.controller;

import com.blog.apllication.payload.CategoryDto;
import com.blog.apllication.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/api/categories")
public class CategoryController {

    @Autowired
    private  CategoryService categoryService;


    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(this.categoryService.createCategory(categoryDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable Integer id){
        return ResponseEntity.ok(this.categoryService.updateCategory(categoryDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id){
        this.categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/")
    public ResponseEntity<java.util.List<CategoryDto>> getAllCategories(){
        return ResponseEntity.ok(this.categoryService.getAllCategory());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.categoryService.getCategoryById(id));
    }


}
