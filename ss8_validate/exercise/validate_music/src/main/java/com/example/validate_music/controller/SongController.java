package com.example.validate_music.controller;

import com.example.validate_music.dto.SongDto;
import com.example.validate_music.model.Song;
import com.example.validate_music.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class SongController {

    @Autowired
    private ISongService iSongService;

    @GetMapping("/music")
    public String showList(Model model) {
        List<Song> songList = iSongService.findAll();
        model.addAttribute("songList", songList);
        return "index";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Validated SongDto songDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {

        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            iSongService.save(song);
            redirectAttributes.addFlashAttribute("message", "create song successful!");
            return "redirect:/music";
        }
    }

    @GetMapping("/{id}/edit")
    public String showFormEdit(@PathVariable int id, Model model) {
        model.addAttribute("songList", iSongService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("songList") @Validated SongDto songDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {

        if (bindingResult.hasFieldErrors()) {
            return "edit";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            iSongService.update(song);
            redirectAttributes.addFlashAttribute("message", "update song successful!");
            return "redirect:/music";
        }
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("songList", iSongService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Song song, RedirectAttributes redirectAttributes) {
        iSongService.remove(song);
        redirectAttributes.addFlashAttribute("message", "Remove song successfully!");
        return "redirect:/music";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("songList", iSongService.findById(id));
        return "view";
    }

    @GetMapping("/search")
    public String search(@RequestParam String name, Model model) {
        model.addAttribute("songList", iSongService.findName(name));
        return "index";
    }
}
