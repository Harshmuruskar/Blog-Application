package com.blog.apllication.service.impl;

import com.blog.apllication.entity.Category;
import com.blog.apllication.entity.Post;
import com.blog.apllication.entity.User;
import com.blog.apllication.payload.PostDto;
import com.blog.apllication.repository.CategoryRepo;
import com.blog.apllication.repository.PostRepo;
import com.blog.apllication.repository.UserRepo;
import com.blog.apllication.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public PostDto creaatePost(PostDto postDto, Integer userId, Integer categoryId) {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new RuntimeException("User not found with id: " + userId));
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new RuntimeException("Category not found with id: " + categoryId));
        Post post = this.modelMapper.map(postDto , Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);
        Post newPost = this.postRepo.save(post);
        return modelMapper.map(newPost, Post.class);
    }

    @Override
    public Post updatePost(PostDto postDto, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public Post getPostById(Integer postId) {
        return null;
    }

    @Override
    public Post getAllPost() {
        return null;
    }

    @Override
    public List<Post> listOfPostByCategory(Integer categoryId) {
        return List.of();
    }

    @Override
    public List<Post> listOfPostByUser(Integer userId) {
        return List.of();
    }

    @Override
    public List<Post> searchPost(String keyword) {
        return List.of();
    }
}
