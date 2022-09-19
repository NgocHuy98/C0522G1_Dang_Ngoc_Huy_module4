package com.example.practice1.service.impl;
import com.example.practice1.model.Customer;
import com.example.practice1.repository.ICustomerRepository;
import com.example.practice1.service.ICustomerService;
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
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }



//    @Override
//    public Page<Customer> findAll(Pageable pageable) {
//        return iCustomerRepository.findAll(pageable);
//    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void update( Customer customer) {
        iCustomerRepository.save( customer);

    }

    @Override
    public void remove(int id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

//    @Override
//    public Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable) {
//        return iCustomerRepository.findAllByFirstNameContaining(firstname,pageable);
//    }
}
