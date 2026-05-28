package com.blog.apllication.service.impl;

import com.blog.apllication.entity.Category;
import com.blog.apllication.entity.Post;
import com.blog.apllication.entity.User;
import com.blog.apllication.exceptions.ResourceNotFoundException;
import com.blog.apllication.payload.PostDto;
import com.blog.apllication.payload.PostResponse;
import com.blog.apllication.repository.CategoryRepo;
import com.blog.apllication.repository.PostRepo;
import com.blog.apllication.repository.UserRepo;
import com.blog.apllication.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
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
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new RuntimeException("User not found with id: " + userId));
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new RuntimeException("Category not found with id: " + categoryId));
        Post post = this.modelMapper.map(postDto , Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);
        Post newPost = this.postRepo.save(post);
        return modelMapper.map(newPost, PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setImageName(postDto.getImageName());
        Post updatedPost = this.postRepo.save(post);
        return this.modelMapper.map(updatedPost, PostDto.class);
    }

    @Override
    public void deletePost(Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        this.postRepo.delete(post);
    }

    @Override
    public PostDto getPostById(Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        return this.modelMapper.map(post, PostDto.class);
    }

    @Override
    public PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
        int safePageNumber = pageNumber == null || pageNumber < 0 ? 0 : pageNumber;
        int safePageSize = pageSize == null || pageSize <= 0 ? 5 : pageSize;
        String safeSortBy = sortBy == null || sortBy.isBlank() ? "addedDate" : sortBy;
        String safeSortDir = sortDir == null || sortDir.isBlank() ? Sort.Direction.DESC.name() : sortDir;

        Sort sort = safeSortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(safeSortBy).ascending()
                : Sort.by(safeSortBy).descending();

        Pageable pageable = PageRequest.of(safePageNumber, safePageSize, sort);
        Page<Post> postPage = this.postRepo.findAll(pageable);
        List<PostDto> postDtos = postPage.getContent().stream()
                .map(post -> this.modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());

        PostResponse postResponse = new PostResponse(
                postDtos,
                postPage.getNumber(),
                postPage.getSize(),
                postPage.getTotalElements(),
                postPage.getTotalPages(),
                postPage.isLast()
        );

        return postResponse;
    }

    @Override
    public List<PostDto> listOfPostByCategory(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
        List<Post> posts = this.postRepo.getAllByCategory(cat);
        return posts.stream().map(post -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> listOfPostByUser(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        List<Post> posts = this.postRepo.getAllByUser(user);
        return posts.stream().map(post -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> searchPost(String keyword) {
        List<Post> posts = this.postRepo.findByTitleContaining(keyword);
        return posts.stream().map(post -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
    }
}
