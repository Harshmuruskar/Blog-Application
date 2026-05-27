package com.blog.apllication.repository;

import com.blog.apllication.entity.Category;
import com.blog.apllication.entity.Post;
import com.blog.apllication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post , Integer> {
    List<Post> getAllByUser(User user);
    List<Category> getAllByCategory(Category category);


}
