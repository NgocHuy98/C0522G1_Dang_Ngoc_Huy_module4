package com.codegym.controller;

import com.codegym.model.Mailbox;
import com.codegym.service.IMailboxService;
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
public class MailboxController {
    @Autowired
    private IMailboxService iMailboxService;

    @GetMapping("/")
    public String listMailbox(Model model) {
        List<Mailbox> mailboxList = iMailboxService.findAllMail();
        model.addAttribute("mailboxList", mailboxList);
        return "index";
    }

    @GetMapping("/update")
    public String showFormUpdate(@RequestParam int id, Model model) {

        model.addAttribute("languageList", iMailboxService.findAllLanguage());
        model.addAttribute("pageSizeList", iMailboxService.findAllPageSize());
        model.addAttribute("mailbox", iMailboxService.findById(id));

        return "update";

    }

    @PostMapping("/save")
    public String update(@ModelAttribute Mailbox mailbox, RedirectAttributes redirectAttributes) {
        iMailboxService.update(mailbox);
        redirectAttributes.addFlashAttribute("message", "Update success!");
        return "redirect:/";
    }


}
