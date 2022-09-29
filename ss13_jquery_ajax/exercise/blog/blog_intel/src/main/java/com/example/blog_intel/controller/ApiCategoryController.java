package com.example.blog_intel.controller;

import com.example.blog_intel.model.Category;
import com.example.blog_intel.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/category")
public class ApiCategoryController {

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping
    public ResponseEntity<List<Category>> showCategory() {
        List<Category> categoryList = iCategoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(categoryList, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable int id) {
        Category category = iCategoryService.findById(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

}
