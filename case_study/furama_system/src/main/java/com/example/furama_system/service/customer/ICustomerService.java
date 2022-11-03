package com.example.furama_system.service.customer;

import com.example.furama_system.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {


     Page<Customer> findAllByName(String search, Pageable pageable);

     void save(Customer customer);

    Optional<Customer> findById(int id);

     void update(Customer customer);

     void remove(int id);

    List<Customer> findAll();

    Page<Customer> findSearch(String name, Pageable pageable);
}
