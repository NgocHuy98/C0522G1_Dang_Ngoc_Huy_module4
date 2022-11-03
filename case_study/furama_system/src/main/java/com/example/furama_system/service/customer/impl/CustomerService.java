package com.example.furama_system.service.customer.impl;

import com.example.furama_system.model.Customer;
import com.example.furama_system.repository.customer.ICustomerRepository;
import com.example.furama_system.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAllByName(String search, Pageable pageable) {
        return iCustomerRepository.findAllByKey(search,pageable);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(int id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void update(Customer customer) {
iCustomerRepository.save(customer);
    }

    @Override
    public void remove(int id) {
iCustomerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Page<Customer> findSearch(String name, Pageable pageable) {
        return iCustomerRepository.pageSearch(name, pageable);
    }
}
