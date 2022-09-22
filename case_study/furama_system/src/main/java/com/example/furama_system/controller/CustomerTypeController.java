package com.example.furama_system.controller;

import com.example.furama_system.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class CustomerTypeController {
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("/type")
    public ModelAndView showCategory() {
        return new ModelAndView("customer/indexType", "customerType", iCustomerTypeService.findAll());
    }

}
