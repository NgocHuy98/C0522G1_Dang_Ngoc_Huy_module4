package com.example.blog_extend.controller;

import com.example.blog_extend.model.Blog;
import com.example.blog_extend.service.IBlogService;
import com.example.blog_extend.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class ApiBlogController {

    @Autowired
    private ICategoryService iCategoryService;

    @Autowired
    private IBlogService iBlogService;

    @GetMapping
    public ResponseEntity<List<Blog>> findAll(){
        List<Blog> blogs = iBlogService.findAll();
        if(blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }

//    @GetMapping("{/id}")
//    public ResponseEntity<Blog> findBlogById(@PathVariable int id){
//       Optional<Blog> blog = Optional.ofNullable(iBlogService.findById(id));
//        if()
//
//    }



//    @GetMapping("/bl")
//    public String showListBlog(Model model) {
//        model.addAttribute("blog", iBlogService.searchByTittle());
//        model.addAttribute("categoryList", iCategoryService.findAll());
//        return "bl/index";
//    }

    @GetMapping("/blog")
    public String showList(@PageableDefault(value = 3, sort = "date_writing") Pageable pageable,
                           @RequestParam(defaultValue = "") String search, Model model) {

        model.addAttribute("blog", iBlogService.findByTittleContaining(search, pageable));
        model.addAttribute("categoryList", iCategoryService.findAll());
        model.addAttribute("search", search);

        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", iCategoryService.findAll());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Create new Blog successfully!");
        return "redirect:/blog";
    }

//    @GetMapping("/{id}/edit")
//    public String edit(@PathVariable int id, Model model) {
//        model.addAttribute("blog", iBlogService.findById(id));
//        model.addAttribute("categoryList", iCategoryService.findAll());
//        return "edit";
//    }
//
//
//    @PostMapping("/update")
//    public String update(@ModelAttribute Blog blog, RedirectAttributes redirect) {
//        iBlogService.update(blog);
//        redirect.addFlashAttribute("message", "Update Blog successfully!");
//        return "redirect:/blog";
//    }
//
//    @GetMapping("/{id}/delete")
//    public String delete(@PathVariable int id, Model model) {
//        model.addAttribute("blog", iBlogService.findById(id));
//        return "delete";
//    }
//
//    @PostMapping("/delete")
//    public String delete(@ModelAttribute Blog blog, RedirectAttributes redirect) {
//        iBlogService.remove(blog.getId());
//        redirect.addFlashAttribute("message", "Removed Blog successfully!");
//        return "redirect:/blog";
//    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "view";

    }
}
