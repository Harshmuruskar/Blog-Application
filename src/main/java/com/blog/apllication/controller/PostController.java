package com.blog.apllication.controller;

import com.blog.apllication.payload.PostDto;
import com.blog.apllication.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,
                                              @PathVariable Integer userId,
                                              @PathVariable Integer categoryId){
        PostDto post = postService.creaatePost(postDto, userId, categoryId);
        return  new  ResponseEntity<PostDto>(post , HttpStatus.CREATED);
    }

}
