package com.codegym.controller;

import com.codegym.model.MedicalDeclaration;
import com.codegym.service.IMedicalDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MedicalDeclarationController {

    @Autowired
    private IMedicalDeclarationService declarationService;

    @GetMapping("/")
    public String listMailbox(Model model) {
        List<MedicalDeclaration > declarations = declarationService.findAll();
        model.addAttribute("declarations", declarations);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<String> genderList = declarationService.findAllGender();
        List<String> nationList = declarationService.findAllNation();
        List<String> travelList = declarationService.findAllTravel();
        model.addAttribute("declaration", new MedicalDeclaration());
        model.addAttribute("genderList", genderList);
        model.addAttribute("nationList", nationList);
        model.addAttribute("travelList", travelList);
        return "create";
    }

    @GetMapping("/update")
    public String showFormUpdate(@RequestParam int id, Model model) {

        model.addAttribute("travelList", declarationService.findAllTravel());
        model.addAttribute("nationList", declarationService.findAllNation());
        model.addAttribute("genderList", declarationService.findAllGender());
        model.addAttribute("declaration", declarationService.findById(id));

        return "update";

    }

    @PostMapping("/save")
    public String update(@ModelAttribute MedicalDeclaration declaration, RedirectAttributes redirectAttributes) {
        declarationService.update(declaration);
        redirectAttributes.addFlashAttribute("message", "Update success!");
        return "redirect:/";
    }
}
