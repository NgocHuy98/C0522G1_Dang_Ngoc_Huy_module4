package com.example.blog_extend_api.service;


import com.example.blog_extend_api.model.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();

    Category findById(int id);

}
