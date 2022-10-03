package com.example.furama_system.controller;

import com.example.furama_system.service.contract.IContractDetailService;
import com.example.furama_system.service.contract.IContractService;
import com.example.furama_system.service.customer.ICustomerService;
import com.example.furama_system.service.employee.IEmployeeService;
import com.example.furama_system.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;
    @Autowired
    private IContractDetailService iContractDetailService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IFacilityService iFacilityService;

    @GetMapping
    public String indexContract(@PageableDefault(value = 3) Pageable pageable, Model model) {
        model.addAttribute("contract", iContractService.findAllContract(pageable));
        return "contract/index";
    }

//    @GetMapping("/create")
//    public String create(Model model) {
//        model.addAttribute("contract", new Contract());
//        model.addAttribute("employee", iEmployeeService.findAll());
//        model.addAttribute("contractDetail", iContractDetailService.findAll());
//        model.addAttribute("customer", iCustomerService.findAll());
//        model.addAttribute("facility", iFacilityService.findAll());
//        return "contract/create";
//    }

//    @PostMapping("/create")
//    public String save(@ModelAttribute Contract contract, RedirectAttributes redirectAttributes) {
//        iEmployeeService.save(contract);
//        redirectAttributes.addFlashAttribute("message", "Create new contract successfully!");
//        return "redirect:/contract";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String edit(@PathVariable int id, Model model) {
//        model.addAttribute("employee", iEmployeeService.findById(id));
//        model.addAttribute("employee", iEmployeeService.findAll());
//        model.addAttribute("contractDetail", iContractDetailService.findAll());
//        model.addAttribute("customer", iCustomerService.findAll());
//        model.addAttribute("facility", iFacilityService.findAll());
//        return "/contract/edit";
//    }
//
//
//    @PostMapping("/update")
//    public String update(@ModelAttribute Contract contract, RedirectAttributes redirect) {
//        iEmployeeService.update(contract);
//        redirect.addFlashAttribute("message", "Update contract successfully!");
//        return "redirect:/contract";
//    }
//
//
//    @GetMapping("/delete")
//    public String delete(@RequestParam(value = "idDelete")int id, RedirectAttributes redirect) {
//        iEmployeeService.remove(id);
//        redirect.addFlashAttribute("success", "Removed contract successfully!");
//        return "redirect:/contract";
//    }
//
//    @GetMapping("/{id}/view")
//    public String view(@PathVariable int id, Model model) {
//        model.addAttribute("contract", iContractService.findById(id));
//        model.addAttribute("employee", iEmployeeService.findAll());
//        model.addAttribute("contractDetail", iContractDetailService.findAll());
//        model.addAttribute("customer", iCustomerService.findAll());
//        model.addAttribute("facility", iFacilityService.findAll());
//        return "/contract/view";
//    }
}
