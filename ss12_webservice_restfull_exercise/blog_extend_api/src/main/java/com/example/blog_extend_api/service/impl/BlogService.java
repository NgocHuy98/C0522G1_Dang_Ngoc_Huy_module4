package com.example.blog_extend_api.service.impl;

import com.example.blog_extend_api.model.Blog;
import com.example.blog_extend_api.repository.IBlogRepository;
import com.example.blog_extend_api.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }


}
