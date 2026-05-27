package com.blog.apllication.service;

import com.blog.apllication.entity.Post;
import com.blog.apllication.payload.PostDto;

import java.util.List;

public interface PostService {

    PostDto creaatePost(PostDto postDto , Integer userId, Integer categoryId);
    Post updatePost(PostDto postDto, Integer postId);
    void deletePost(Integer postId);
    Post getPostById(Integer postId);
    Post getAllPost();
    List<Post> listOfPostByCategory(Integer categoryId);
    List<Post> listOfPostByUser(Integer userId);

    List<Post> searchPost(String keyword);

}
