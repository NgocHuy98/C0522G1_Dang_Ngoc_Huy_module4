package com.example.furama_system.controller;

import com.example.furama_system.model.Facility;
import com.example.furama_system.service.facility.IFacilityService;
import com.example.furama_system.service.facility.IFacilityTypeService;
import com.example.furama_system.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    private IFacilityService iFacilityService;

    @Autowired
    private IFacilityTypeService iFacilityTypeService;

    @Autowired
    private IRentTypeService iRentTypeService;

    @GetMapping
    public String indexFacility(@PageableDefault(value = 3, sort = "name") Pageable pageable,
                                @RequestParam(value = "search", defaultValue = "") String search, Model model) {
        model.addAttribute("facility", iFacilityService.findByNameContaining(search, pageable));
        model.addAttribute("search", search);
        return "facility/index";
    }

    @GetMapping("/create")
    public String createFacility(Model model) {
        model.addAttribute("facility", new Facility());
        model.addAttribute("facilityType", iFacilityTypeService.findAll());
        model.addAttribute("rentType", iRentTypeService.findAll());
        return "facility/create";
    }

    @PostMapping("/create")
    public String saveFacility(@ModelAttribute Facility facility, RedirectAttributes redirectAttributes) {
        iFacilityService.save(facility);
        redirectAttributes.addFlashAttribute("message", "Create new facility successfully!");
        return "redirect:/facility";
    }

    @GetMapping("/{id}/edit")
    public String editFacility(@PathVariable int id, Model model) {
        model.addAttribute("facility", iFacilityService.findById(id));
        model.addAttribute("facilityType", iFacilityTypeService.findAll());
        model.addAttribute("rentType", iRentTypeService.findAll());
        return "/facility/edit";
    }


    @PostMapping("/update")
    public String updateFacility(@ModelAttribute Facility facility, RedirectAttributes redirect) {
        iFacilityService.update(facility);
        redirect.addFlashAttribute("message", "Update facility successfully!");
        return "redirect:/facility";
    }


    @GetMapping("/delete")
    public String deleteFacility(@RequestParam(value = "idDelete")int id, RedirectAttributes redirect) {
        iFacilityService.remove(id);
        redirect.addFlashAttribute("success", "Removed facility successfully!");
        return "redirect:/facility";
    }

//    @GetMapping("/{id}/view")
//    public String view(@PathVariable int id, Model model) {
//        model.addAttribute("facilityType", iFacilityTypeService.findAll());
//        model.addAttribute("rentType", iRentTypeService.findAll());
//        model.addAttribute("facility", iFacilityService.findById(id));
//        return "/facility/view";
//    }

}

