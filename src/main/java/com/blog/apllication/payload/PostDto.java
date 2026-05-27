package com.blog.apllication.payload;

import com.blog.apllication.entity.Category;
import com.blog.apllication.entity.User;

import java.util.Date;

public class PostDto {

    private String title;
    private String content;
    private String imageName;
    private Date addedDate;
    private Category category;
    private User user;

}
