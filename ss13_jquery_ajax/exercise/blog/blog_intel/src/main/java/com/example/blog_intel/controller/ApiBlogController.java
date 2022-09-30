package com.example.blog_intel.controller;

import com.example.blog_intel.model.Blog;
import com.example.blog_intel.service.IBlogService;
import com.example.blog_intel.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/blog")
public class ApiBlogController {


    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/list")
    public ResponseEntity<List<Blog>> findAll() {
        List<Blog> blogs = iBlogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable int id) {
        Blog blog = iBlogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> searchBlog(@RequestParam(defaultValue = "") String search ) {
        List<Blog> blogs = iBlogService.findBlog(search);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

}
