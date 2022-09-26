package com.example.blog_extend.service;

import com.example.blog_extend.model.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();

    Category findById(int id);

    void save(Category category);

    void update(Category category);

    void remove(int id);
}
