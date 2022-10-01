package com.example.furama_system.service.customer;

import com.example.furama_system.model.CustomerType;


import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
}
