package com.example.furama_system.controller;

import com.example.furama_system.dto.CustomerDto;
import com.example.furama_system.dto.EmployeeDto;
import com.example.furama_system.model.Customer;
import com.example.furama_system.service.customer.ICustomerService;
import com.example.furama_system.service.customer.ICustomerTypeService;
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
@RequestMapping("/customer")

public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;


    @GetMapping
    public String indexCustomer(@PageableDefault(value = 3, sort = "name") Pageable pageable,
                                @RequestParam(value = "search", defaultValue = "")
                                        String search, Model model) {
        model.addAttribute("customer", iCustomerService.findAllByName(search, pageable));
        model.addAttribute("customerType", iCustomerTypeService.findAll());
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("search", search);
        return "customer/index";
    }

    @GetMapping("/create")
    public String createCustomer(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerType", iCustomerTypeService.findAll());
        return "customer/create";
    }

    @PostMapping("/create")
    public String saveCustomer(@ModelAttribute @Validated CustomerDto customerDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerType", iCustomerTypeService.findAll());
            return "customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Create new customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/edit")
    public String editCustomer(@PathVariable int id, Model model) {
        Customer customer = iCustomerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        model.addAttribute("customerDto", customerDto);
        model.addAttribute("customerType", iCustomerTypeService.findAll());
        return "/customer/edit";
    }


    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult,
                         RedirectAttributes redirect, Model model) {

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerType", iCustomerTypeService.findAll());
            return "customer/edit";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        iCustomerService.update(customer);
        redirect.addFlashAttribute("message", "Update customer successfully!");
        return "redirect:/customer";
    }


    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam(value = "idDelete") int id, RedirectAttributes redirect) {
        iCustomerService.remove(id);
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customer";
    }

//    @GetMapping("/{id}/view")
//    public String view(@PathVariable int id, Model model) {
//        model.addAttribute("customerType",iCustomerTypeService.findAll());
//        model.addAttribute("customer", iCustomerService.findById(id));
//        return "/customer/view";
//    }
}
