package com.example.blog_extend.controller;

import com.example.blog_extend.model.Category;
import com.example.blog_extend.service.IBlogService;
import com.example.blog_extend.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;

    @Autowired
    private IBlogService iBlogService;

    @GetMapping
    public ModelAndView showCategory() {
        return new ModelAndView("category/index", "categoryList", iCategoryService.findAll());
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("categoryList", new Category());
        return "category/create";
    }

    @PostMapping("/save")
    public String save(Category category, RedirectAttributes redirectAttributes) {
        iCategoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "successfully added new !!");
        return "redirect:/category";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("categoryList", iCategoryService.findById(id));
        return "category/edit";
    }

    @PostMapping("/update")
    public String update(Category category, RedirectAttributes redirectAttributes) {
        iCategoryService.update(category);
        redirectAttributes.addFlashAttribute("message", "edit successfully!");
        return "redirect:/category";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("categoryList", iCategoryService.findById(id));
        return "category/delete";
    }

    @PostMapping("/delete")
    public String delete(Category category, RedirectAttributes redirect) {
        iCategoryService.remove(category.getId());
        redirect.addFlashAttribute("success", "Removed Category successfully!");
        return "redirect:/category";
    }

    @GetMapping("/view/{id}")
    public String view(@PageableDefault(value = 2) @PathVariable int id, Pageable pageable, Model model) {
        model.addAttribute("blog", iBlogService.findByAllBlog(id,pageable));
        return "index";
    }
}
