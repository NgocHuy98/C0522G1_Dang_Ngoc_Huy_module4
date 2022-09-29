package com.example.blog_intel.service;


import com.example.blog_intel.model.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();

    Category findById(int id);

}
