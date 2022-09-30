package com.example.blog_intel.service.impl;

import com.example.blog_intel.model.Blog;
import com.example.blog_intel.repository.IBlogRepository;
import com.example.blog_intel.service.IBlogService;
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

    @Override
    public List<Blog> findBlog(String search) {
        return iBlogRepository.findBlog(search);
    }

    @Override
    public void remove(int id) {
        iBlogRepository.deleteById(id);
    }


}
