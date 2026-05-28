package com.blog.apllication.service;

import com.blog.apllication.payload.PostDto;

import org.springframework.data.domain.Page;

import java.util.List;

public interface PostService {

    PostDto createPost (PostDto postDto , Integer userId, Integer categoryId);
    PostDto updatePost(PostDto postDto, Integer postId);
    void deletePost(Integer postId);
    PostDto getPostById(Integer postId);
    Page<PostDto> getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
    List<PostDto> listOfPostByCategory(Integer categoryId);
    List<PostDto> listOfPostByUser(Integer userId);

    List<PostDto> searchPost(String keyword);

}
