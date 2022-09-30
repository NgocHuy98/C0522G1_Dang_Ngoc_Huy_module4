package com.example.blog_intel.service;

import com.example.blog_intel.model.Blog;

import java.util.List;

public interface IBlogService {

    Blog findById(int id);

    void save(Blog blog);

    List<Blog> findAll();

    List<Blog> findBlog(String search);

    void remove(int id);
}
