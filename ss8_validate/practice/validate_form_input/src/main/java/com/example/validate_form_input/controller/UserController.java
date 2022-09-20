package com.example.validate_form_input.controller;

import com.example.validate_form_input.model.User;
import com.example.validate_form_input.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping({"/create"})
    public String showCreate(Model model) {
        model.addAttribute("user", iUserService.findAll());
        return "index";
    }

    @PostMapping("/create")
    public String checkValidation(@Validated @ModelAttribute("user") User user, BindingResult bindingResult,
                                  Model model, RedirectAttributes redirectAttributes
    ) {


        if (bindingResult.hasFieldErrors()) {
            return "index";
        } else {
            User user1 = new User();
//            BeanUtils.copyProperties(user,user1);
            iUserService.save(user1);
            redirectAttributes.addFlashAttribute("message",
                    "Create Student: " + user1.getName() + "ok");
            return "redirect:/";

        }
    }
}