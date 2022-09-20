package com.example.blog_extend.service.impl;

import com.example.blog_extend.model.Blog;
import com.example.blog_extend.repository.IBlogRepository;
import com.example.blog_extend.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public void update(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findByTittleContaining(String name, Pageable pageable) {
        return iBlogRepository.findByTittleContaining(name,pageable);
    }

//    @Override
//    public Page<Blog> searchByName(String name,Pageable pageable) {
//        return iBlogRepository.searchByName(name,pageable);
//    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findByAllBlog(int id, Pageable pageable) {
        return iBlogRepository.findByAllBlog(id,pageable);
    }


}
