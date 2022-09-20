package com.example.validate_form.controller;

import com.example.validate_form.dto.ValidateDto;
import com.example.validate_form.model.Validator;
import com.example.validate_form.service.IValidateService;
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
public class ValidateController {

    @Autowired
    private IValidateService iValidateService;

    @GetMapping("/")
    public String showList(Model model) {
        List<Validator> validators = iValidateService.findAll();
        model.addAttribute("validators", validators);
        return "index";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("validateDto", new ValidateDto());
        return "create";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute @Validated ValidateDto validateDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        new ValidateDto().validate(validateDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            Validator validator = new Validator();
            BeanUtils.copyProperties(validateDto, validator);
            iValidateService.save(validator);
            redirectAttributes.addFlashAttribute("message", validator.getEmail() + "OK");
            return "index";
        }
    }
}
