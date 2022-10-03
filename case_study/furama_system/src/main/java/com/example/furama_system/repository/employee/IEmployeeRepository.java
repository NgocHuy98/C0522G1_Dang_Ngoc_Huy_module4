package com.example.furama_system.repository.employee;

import com.example.furama_system.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findById(int id);

    @Query(value = "select * from employee where name_employee like %:key% and is_delete = 0", nativeQuery = true)
    Page<Employee> findAllByKey(@Param("key") String search, Pageable pageable);

    @Modifying
    @Query(value = "update employee set is_delete = 1 where id = :keyword", nativeQuery = true)
    void deleteById(@Param("keyword") int id);
}
