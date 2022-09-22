package com.example.borrow_book.controller;

import com.example.borrow_book.model.Library;
import com.example.borrow_book.service.ILibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LibraryController {

    @Autowired
    private ILibraryService iLibraryService;

    @GetMapping("/library")
    public String showList(@PageableDefault(value = 3) Pageable pageable,
                           @RequestParam(defaultValue = "") String search, Model model) {

        model.addAttribute("library", iLibraryService.findByNameContaining(search, pageable));

        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("library", new Library());

        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Library library, RedirectAttributes redirectAttributes) {
        iLibraryService.save(library);
        redirectAttributes.addFlashAttribute("message", "Create new book successfully!");
        return "redirect:/library";
    }

    @GetMapping("/{id}/edit")
    public String borrow(@PathVariable int id, Model model) throws Exception {
        Library library = iLibraryService.findById(id);

        if (library.getAmount() == 0) {
            throw new Exception();
        } else {
            model.addAttribute("library", library);
            return "edit";
        }

    }

    @PostMapping("/edit")
    public String showBorrow(@ModelAttribute Library library, RedirectAttributes redirect) {
        library.setAmount(library.getAmount() - 1);
        iLibraryService.save(library);
        redirect.addFlashAttribute("message", "Borrow book successfully! "
                + library.getId() + "  Please keep the code to pay");
        return "redirect:/library";
    }

    @GetMapping("/{id}/update")
    public String pay(@PathVariable int id, Model model) {
        Library library = iLibraryService.findById(id);
        model.addAttribute("library", library);
        return "update";

    }

    @PostMapping("/update")
    public String showPay(@ModelAttribute Library library, RedirectAttributes redirect) {
        library.setAmount(library.getAmount() + 1);
        iLibraryService.update(library);
        redirect.addFlashAttribute("message", "Pay book successfully! "
                + library.getId());
        return "redirect:/library";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("library", iLibraryService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Library library, RedirectAttributes redirect) {
        iLibraryService.remove(library.getId());
        redirect.addFlashAttribute("message", "Removed library successfully!");
        return "redirect:/library";
    }


}
