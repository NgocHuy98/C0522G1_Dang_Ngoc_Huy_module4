package com.example.validate_form.controller;

import com.example.validate_form.dto.UserDto;
import com.example.validate_form.model.User;
import com.example.validate_form.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/")
    public String showList(Model model) {
        List<User> users = iUserService.findAll();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "create";
    }

    @PostMapping("/save")
    public String createUser(@ModelAttribute @Validated UserDto userDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            iUserService.save(user);
            redirectAttributes.addFlashAttribute("message", user.getEmail() + "is OK");
            return "redirect:/";
        }
    }
}
