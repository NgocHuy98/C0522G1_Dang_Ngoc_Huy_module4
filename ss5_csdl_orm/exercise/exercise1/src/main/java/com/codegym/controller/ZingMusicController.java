package com.codegym.controller;

import com.codegym.model.ZingMusic;
import com.codegym.service.IZingMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/music")
public class ZingMusicController {

    @Autowired
   IZingMusicService iZingMusicService;

    @GetMapping("")
    public String index(Model model) {

        List<ZingMusic> musicList = iZingMusicService.findAll();
        model.addAttribute("musics", musicList);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("zingMusic",new ZingMusic());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute ZingMusic zingMusic, RedirectAttributes redirectAttributes){
        zingMusic.setId((int) (Math.random() * 1000));
        iZingMusicService.save(zingMusic);
        redirectAttributes.addFlashAttribute("message","Create new song successfully!");
    return "redirect:/music";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("zingMusic", iZingMusicService.findById(id));
        return "edit";
    }


    @PostMapping("/update")
    public String update(@ModelAttribute ZingMusic zingMusic, RedirectAttributes redirect) {
        iZingMusicService.update(zingMusic);
        redirect.addFlashAttribute("message", "Update song successfully!");
        return "redirect:/music";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("zingMusic", iZingMusicService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute ZingMusic zingMusic, RedirectAttributes redirect) {
        iZingMusicService.remove(zingMusic.getId());
        redirect.addFlashAttribute("message", "Removed song successfully!");
        return "redirect:/music";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("zingMusic", iZingMusicService.findById(id));
        return "view";
    }

    @GetMapping("/search")
    public String search(@RequestParam String name,Model model){
        model.addAttribute("zingMusic",iZingMusicService.findByName(name));
        return "index";
    }

}
