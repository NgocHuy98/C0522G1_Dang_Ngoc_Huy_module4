package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller


public class ProductController {

    @Autowired
   private IProductService iProductService;

//    @GetMapping({"/product","/"})
//    public String index(Model model) {
//        List<Product> productList = iProductService.findAll();
//        model.addAttribute("product", productList);
//        return "index";
//    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Product product,RedirectAttributes redirectAttributes) {
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("message","Create new product successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "edit";
    }


    @PostMapping("/update")
    public String update(@ModelAttribute Product product, RedirectAttributes redirect) {
        iProductService.update(product);
        redirect.addFlashAttribute("message", "Update product successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Product product, RedirectAttributes redirect) {
        iProductService.remove(product.getId());
        redirect.addFlashAttribute("message", "Removed product successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "view";
    }

//    @GetMapping("/search")
//    public String search(@RequestParam String name,Model model){
//        model.addAttribute("product",iProductService.searchByName(name));
//        return "index";
//    }

    @GetMapping({"/","/product"})
    public String search(@RequestParam(defaultValue = "") String name, Model model) {
        model.addAttribute("product", iProductService.searchByName(name));
        return "index";
    }


}
