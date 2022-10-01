package com.example.furama_system.service.impl.customer;

import com.example.furama_system.model.CustomerType;
import com.example.furama_system.repository.customer.ICustomerTypeRepository;
import com.example.furama_system.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {

    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return iCustomerTypeRepository.findAll();
    }
}
