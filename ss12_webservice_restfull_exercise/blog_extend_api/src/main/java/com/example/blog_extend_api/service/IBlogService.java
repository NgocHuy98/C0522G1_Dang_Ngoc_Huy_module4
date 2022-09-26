package com.example.blog_extend_api.service;
import com.example.blog_extend_api.model.Blog;

import java.util.List;

public interface IBlogService {

    Blog findById(int id);

    void save(Blog blog);

    List<Blog> findAll();
}
