package com.blog.apllication.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

    private Integer id;
    @NotEmpty(message = "Name cannot be null")
    @Size(min = 4, message = "Name must be at least 4 characters long")
    private String name;
    @Email(message = "Email should be valid")
    private String email;
    @NotEmpty(message = "Password cannot be null")
    private String password;
    @NotEmpty(message = "About cannot be null")
    private String about;

}
