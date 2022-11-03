package com.example.furama_system.controller;

import com.example.furama_system.model.Customer;
import com.example.furama_system.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/customer/api")
public class RestCustomerController {
  @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("/list")
    public ResponseEntity<Page<Customer>> showCustomer(@RequestParam(value = "name", defaultValue = "") String name,
                                                        @PageableDefault Pageable pageable) {

        Page<Customer> customerPage = iCustomerService.findSearch(name, pageable);
        if(customerPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerPage, HttpStatus.OK);
    }


}
