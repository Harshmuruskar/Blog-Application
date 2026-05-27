package com.blog.apllication.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryDto {
    private Integer categoryId;
    @NotBlank(message = "Title cannot be null")
    @Size(min = 4, message = "Title must be at least 4 characters long")
    private String categoryTitle;

    @Size(min = 10, message = "Description must be at least 10 characters long")
    private String categoryDescription;
}

