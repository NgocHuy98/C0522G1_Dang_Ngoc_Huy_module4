package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoneyController {
    @GetMapping("/")
    public String convert(){
        return "index";
    }
    @GetMapping("/convert")
    public String converted(@RequestParam double usd, Model model){
        model.addAttribute("kq",(usd*23000));
        return "index";
    }
}
