package com.example.blog.service;

import com.example.blog.model.Blog;

import java.util.List;

public interface IBlogService {

    Blog findById(int id);

    void update(Blog blog);

    void remove(int id);

    List<Blog> searchByName(String name);

    List<Blog> findAll();

    void save(Blog blog);
}
