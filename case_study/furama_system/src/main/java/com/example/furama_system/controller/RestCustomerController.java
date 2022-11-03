package com.example.furama_system.controller;

import com.example.furama_system.dto.CustomerDto;
import com.example.furama_system.model.Customer;
import com.example.furama_system.model.CustomerType;
import com.example.furama_system.service.customer.ICustomerService;
import com.example.furama_system.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/customer/api")
public class RestCustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("/list")
    public ResponseEntity<Page<Customer>> showCustomer(@RequestParam(value = "name", defaultValue = "") String name,
                                                       @PageableDefault Pageable pageable) {

        Page<Customer> customerPage = iCustomerService.findSearch(name, pageable);
        if (customerPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerPage, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Page<Customer>> createCustomer(@RequestBody CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        iCustomerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/type")
    public ResponseEntity<List<CustomerType>> getCustomerTypeList() {
        List<CustomerType> customerType = iCustomerTypeService.findAll();

        if (customerType.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(customerType, HttpStatus.OK);
        }
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Customer> saveEditing(@RequestBody CustomerDto customerDto,
                                                @PathVariable int id) {
        Customer customer = iCustomerService.findById(id).get();
        BeanUtils.copyProperties(customerDto, customer);
        iCustomerService.update(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable int id) {

        Customer customer = iCustomerService.findById(id).get();
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable int id) {
        Optional<Customer> customer = iCustomerService.findById(id);
        if (customer.isPresent()) {
            iCustomerService.remove(id);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

