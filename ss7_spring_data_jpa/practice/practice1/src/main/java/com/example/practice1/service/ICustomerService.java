package com.example.practice1.service;



import com.example.practice1.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAll();

  

    void save(Customer customer);

    Customer findById(int id);

    void update( Customer customer);

    void remove(int id);

    Page<Customer> findAll(Pageable pageable);
//
//    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
