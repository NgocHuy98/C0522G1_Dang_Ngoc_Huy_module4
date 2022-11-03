package com.example.test.controller;

import com.example.test.dto.ProductDto;
import com.example.test.model.Product;
import com.example.test.service.IProductService;
import com.example.test.service.IProductTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @Autowired
    IProductTypeService iProductTypeService;

    @GetMapping
    public String indexProduct(@PageableDefault(value = 3, sort = "name") Pageable pageable,
                               @RequestParam(value = "name", defaultValue = "")
                                       String nameSearch,
                               @RequestParam(value = "price", defaultValue = "")
                                       String priceSearch,
                               @RequestParam(value = "type", defaultValue = "")
                                       String typeSearch, Model model) {
        model.addAttribute("product", iProductService.findAllByName(nameSearch, priceSearch,
                typeSearch, pageable));
        model.addAttribute("productType", iProductTypeService.findAll());
        model.addAttribute("productDto", new ProductDto());
        model.addAttribute("name", nameSearch);
        model.addAttribute("price", priceSearch);
        model.addAttribute("type", typeSearch);
        return "product/index";
    }

    @GetMapping("/create")
    public String createProduct(Model model) {
        model.addAttribute("productDto", new Product());
        model.addAttribute("productType", iProductTypeService.findAll());
        return "product/create";
    }

    @PostMapping("/create")
    public String saveProduct(@ModelAttribute @Validated ProductDto productDto,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("productType", iProductTypeService.findAll());
            return "product/create";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("message", "Create new product successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String editProduct(@PathVariable int id, Model model) {
        Product product = iProductService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        model.addAttribute("productDto", productDto);
        model.addAttribute("productType", iProductTypeService.findAll());
        return "/product/edit";
    }


    @PostMapping("/update")
    public String updateProduct(@ModelAttribute @Validated ProductDto productDto, BindingResult bindingResult,
                                RedirectAttributes redirect, Model model) {

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("productType", iProductTypeService.findAll());
            return "product/edit";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        iProductService.update(product);
        redirect.addFlashAttribute("message", "Update product successfully!");
        return "redirect:/customer";
    }


    @GetMapping("/delete")
    public String deleteProduct(@RequestParam(value = "idDelete") int id, RedirectAttributes redirect) {
        iProductService.remove(id);
        redirect.addFlashAttribute("message", "Removed product successfully!");
        return "redirect:/product";
    }


}
