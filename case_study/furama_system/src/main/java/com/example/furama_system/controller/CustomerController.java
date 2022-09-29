package com.example.furama_system.controller;

import com.example.furama_system.model.Customer;
import com.example.furama_system.service.ICustomerService;
import com.example.furama_system.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;


    @GetMapping
    public String home() {
        return "home";
    }


    @GetMapping("/customer")
    public String indexCustomer(@PageableDefault(value = 3, sort = "name") Pageable pageable,
                                @RequestParam(defaultValue = "") String search, Model model) {
        model.addAttribute("customer", iCustomerService.findByNameContaining(search, pageable));
        model.addAttribute("customerType", iCustomerTypeService.findAll());
        model.addAttribute("search", search);
        return "customer/index";
    }

    @GetMapping("/customer/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerType", iCustomerService.findAll());
        return "customer/create";
    }

    @PostMapping("/customer/create")
    public String save(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Create new customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id));
        model.addAttribute("customerType", iCustomerTypeService.findAll());
        return "/customer/edit";
    }


    @PostMapping("/update")
    public String update(@ModelAttribute Customer customer, RedirectAttributes redirect) {
        iCustomerService.update(customer);
        redirect.addFlashAttribute("message", "Update customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id));
        return "/customer/delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Customer customer, RedirectAttributes redirect) {
        iCustomerService.remove(customer.getId());
        redirect.addFlashAttribute("message", "Removed customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customerType",iCustomerTypeService.findAll());
        model.addAttribute("customer", iCustomerService.findById(id));
        return "/customer/view";
    }
}
