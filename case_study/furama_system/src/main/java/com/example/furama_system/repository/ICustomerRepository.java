package com.example.furama_system.repository;

import com.example.furama_system.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

    Customer findById(int id);

    Page<Customer> findByNameContaining(String search, Pageable pageable);
}
