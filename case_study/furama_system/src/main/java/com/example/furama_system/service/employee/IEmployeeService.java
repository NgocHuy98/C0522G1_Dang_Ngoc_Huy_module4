package com.example.furama_system.service.employee;

import com.example.furama_system.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {

     Page<Employee> findAllByName(String search, Pageable pageable);

     void save(Employee employee);

     Employee findById(int id);

     void update(Employee employee);

     void remove(int id);

    List<Employee> findAll();
}
