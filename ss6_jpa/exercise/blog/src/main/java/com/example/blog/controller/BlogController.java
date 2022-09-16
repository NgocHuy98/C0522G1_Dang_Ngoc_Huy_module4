package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class BlogController {
    @Autowired
    IBlogService iBlogService;

    @GetMapping({"/blog","/"})
    public String index(Model model) {
        List<Blog> blogList = iBlogService.findAll();
        model.addAttribute("blog", blogList);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blog.setId((int) (Math.random() * 10000));
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("message","Create new Blog successfully!");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "edit";
    }


    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirect) {
        iBlogService.update(blog);
        redirect.addFlashAttribute("message", "Update Blog successfully!");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Blog blog, RedirectAttributes redirect) {
        iBlogService.remove(blog.getId());
        redirect.addFlashAttribute("message", "Removed Blog successfully!");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "view";
    }

    @GetMapping("/search")
    public String search(@RequestParam String name, Model model){
        model.addAttribute("blog",iBlogService.searchByName(name));
        return "index";
    }
}
