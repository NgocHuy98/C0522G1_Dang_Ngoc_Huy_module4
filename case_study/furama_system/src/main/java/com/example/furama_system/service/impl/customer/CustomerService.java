package com.example.furama_system.service.impl.customer;

import com.example.furama_system.model.Customer;
import com.example.furama_system.repository.customer.ICustomerRepository;
import com.example.furama_system.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAllByKey(String search, Pageable pageable) {
        return iCustomerRepository.findAllByKey(search,pageable);
    }

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
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
}
