package com.example.blog_extend.service;

import com.example.blog_extend.dto.BlogDto;
import com.example.blog_extend.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {

    Blog findById(int id);

    void update(Blog blog);

    void remove(int id);

//    List<Blog> findAll();

//    Page<Blog> searchByName(String name, Pageable pageable);

    Page<Blog>findByTittleContaining(String name, Pageable pageable);

    void save(Blog blog);

    Page<Blog> findAll(Pageable pageable);


    Page<Blog> findByAllBlog(int id, Pageable pageable);

    List<BlogDto> searchByTittle();

    List<Blog> findAll();
}
