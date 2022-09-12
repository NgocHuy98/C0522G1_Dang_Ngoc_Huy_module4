package com.spring.controller;

import com.spring.service.ILanguageService;
import com.spring.service.impl.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TranslateController {

    private ILanguageService iLanguageService = new LanguageService();

    @GetMapping("/")
    public String translate() {
        return "index";
    }

    @GetMapping("/translate")
    public String translated(@RequestParam String english, Model model) {
        String translate = iLanguageService.translate(english);
        if (translate != null) {
            model.addAttribute("translate", translate);
        } else {
            model.addAttribute("translate", "Not found");
        }
        return "index";
    }


}
