package com.example.furama_system.controller;

import com.example.furama_system.dto.ContractDto;
import com.example.furama_system.dto.EmployeeDto;
import com.example.furama_system.model.Contract;
import com.example.furama_system.model.Employee;
import com.example.furama_system.service.employee.IDivisionService;
import com.example.furama_system.service.employee.IEducationDegreeService;
import com.example.furama_system.service.employee.IEmployeeService;
import com.example.furama_system.service.employee.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IPositionService iPositionService;

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IDivisionService iDivisionService;

    @Autowired
    private IEducationDegreeService degreeService;

    @GetMapping
    public String indexFacility(@PageableDefault(value = 3, sort = "name_employee") Pageable pageable,
                                @RequestParam(value = "search", defaultValue = "") String search, Model model) {
        model.addAttribute("employee", iEmployeeService.findAllByName(search, pageable));
        model.addAttribute("division", iDivisionService.findAll());
        model.addAttribute("position", iPositionService.findAll());
        model.addAttribute("degree", degreeService.findAll());
        model.addAttribute("employeeDto", new EmployeeDto());
        model.addAttribute("search", search);
        return "employee/index";
    }

    @PostMapping("/create")
    public String saveEmployee(@ModelAttribute @Validated EmployeeDto employeeDto, BindingResult bibi,
                               RedirectAttributes redirectAttributes, Model model) {
        if (bibi.hasFieldErrors()) {
            model.addAttribute("divisionList", iDivisionService.findAll());
            model.addAttribute("educationDegreeList", degreeService.findAll());
            model.addAttribute("positionList", iPositionService.findAll());
            return "employee/index";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        iEmployeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "Create new employee successfully!!");
        return "redirect:/employee";
    }

//    @PostMapping("/create")
//    public String save(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes) {
//
//        iEmployeeService.save(employee);
//        redirectAttributes.addFlashAttribute("message", "Create new employee successfully!");
//        return "redirect:/employee";
//    }

    @GetMapping("/{id}/edit")
    public String editEmployee(@PathVariable int id, Model model) {

        Employee employee = iEmployeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        model.addAttribute("employeeDto", employeeDto);
        model.addAttribute("division", iDivisionService.findAll());
        model.addAttribute("position", iPositionService.findAll());
        model.addAttribute("degree", degreeService.findAll());
        return "/employee/edit";
    }

    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute  EmployeeDto employeeDto,
                         RedirectAttributes redirect, Model model) {
//        if (bindingResult.hasFieldErrors()) {
//            model.addAttribute("division", iDivisionService.findAll());
//            model.addAttribute("position", iPositionService.findAll());
//            model.addAttribute("degree", degreeService.findAll());
//            return "employee/edit";
//        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        iEmployeeService.update(employee);
        redirect.addFlashAttribute("message", "Update employee successfully!");
        return "redirect:/employee";
    }

//    @PostMapping("/update")
//    public String update(@ModelAttribute Employee employee,
//                         RedirectAttributes redirect) {
//        iEmployeeService.update(employee);
//        redirect.addFlashAttribute("message", "Update employee successfully!");
//        return "redirect:/employee";
//    }


    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam(value = "idDelete") int id, RedirectAttributes redirect) {
        iEmployeeService.remove(id);
        redirect.addFlashAttribute("success", "Removed employee successfully!");
        return "redirect:/employee";
    }

//    @GetMapping("/{id}/view")
//    public String view(@PathVariable int id, Model model) {
//        model.addAttribute("employee", iEmployeeService.findById(id));
//        model.addAttribute("division", iDivisionService.findAll());
//        model.addAttribute("position", iPositionService.findAll());
//        model.addAttribute("degree", degreeService.findAll());
//        return "/employee/view";
//    }

}
