package com.example.practice1.repository;

import com.example.practice1.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.awt.print.Pageable;
@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

    Customer findById(int id);

}
