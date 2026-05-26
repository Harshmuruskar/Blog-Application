package com.blog.apllication.service;

import com.blog.apllication.entity.User;
import com.blog.apllication.payload.UserDto;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user, Integer id);
    UserDto getUserById(Integer id);
    List<UserDto> getAllUsers();
    void deleteUser(Integer id);

}
