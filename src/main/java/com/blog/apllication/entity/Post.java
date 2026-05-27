package com.blog.apllication.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer postId;
    @Column(name = "post_title", nullable = false, length = 100)
    private String title;
    @Column(length = 10000)
    private String content;
    private String imageName;
    private Date addedDate;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    private User user;



}
