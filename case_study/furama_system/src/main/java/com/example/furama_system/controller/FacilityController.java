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
public class FacilityController {

        @Autowired
        private IFacilityService iFacilityService;

        @Autowired
        private IFacilityTypeService iFacilityTypeService;

        @Autowired
        private IRentTypeService iRentTypeService;

        @GetMapping("/facility")
        public String indexFacility(@PageableDefault(value = 3, sort = "name") Pageable pageable,
                                    @RequestParam(defaultValue = "") String search, Model model) {
            model.addAttribute("facility", iFacilityService.findByNameContaining(search, pageable));
            model.addAttribute("facilityType", iFacilityTypeService.findAll());
            model.addAttribute("rentType", iRentTypeService.findAll());
            model.addAttribute("search", search);
            return "facility/index";
        }

        @GetMapping("/facility/create")
        public String create(Model model) {
            model.addAttribute("facility", new Facility());
            model.addAttribute("facilityType", iFacilityTypeService.findAll());
            model.addAttribute("rentType", iRentTypeService.findAll());
            return "facility/create";
        }

        @PostMapping("/facility/create")
        public String save(@ModelAttribute Facility facility, RedirectAttributes redirectAttributes) {
            iFacilityService.save(facility);
            redirectAttributes.addFlashAttribute("message", "Create new facility successfully!");
            return "redirect:/facility";
        }

        @GetMapping("/{id}/facility/edit")
        public String edit(@PathVariable int id, Model model) {
            model.addAttribute("facility", iFacilityService.findById(id));
            model.addAttribute("facilityType", iFacilityTypeService.findAll());
            model.addAttribute("rentType", iRentTypeService.findAll());
            return "/facility/edit";
        }


        @PostMapping("/facility/update")
        public String update(@ModelAttribute Facility facility, RedirectAttributes redirect) {
            iFacilityService.update(facility);
            redirect.addFlashAttribute("message", "Update facility successfully!");
            return "redirect:/facility";
        }

        @GetMapping("/{id}/facility/delete")
        public String delete(@PathVariable int id, Model model) {
            model.addAttribute("facility", iFacilityService.findById(id));
            return "/facility/delete";
        }

        @PostMapping("/facility/delete")
        public String delete(@ModelAttribute Facility facility, RedirectAttributes redirect) {
            iFacilityService.remove(facility.getId());
            redirect.addFlashAttribute("message", "Removed facility successfully!");
            return "redirect:/facility";
        }

        @GetMapping("/{id}/facility/view")
        public String view(@PathVariable int id, Model model) {
            model.addAttribute("facilityType",iFacilityTypeService.findAll());
            model.addAttribute("rentType",iRentTypeService.findAll());
            model.addAttribute("facility", iFacilityService.findById(id));
            return "/facility/view";
        }

}
