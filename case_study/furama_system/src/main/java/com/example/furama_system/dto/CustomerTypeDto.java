package com.example.furama_system.dto;

import com.example.furama_system.model.Customer;

import java.util.Set;

public class CustomerTypeDto {
    private int id;

    private String name;

    private Set<Customer> customerSet;

    public CustomerTypeDto() {
    }

    public CustomerTypeDto(int id, String name, Set<Customer> customerSet) {
        this.id = id;
        this.name = name;
        this.customerSet = customerSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Customer> getCustomerSet() {
        return customerSet;
    }

    public void setCustomerSet(Set<Customer> customerSet) {
        this.customerSet = customerSet;
    }
}
