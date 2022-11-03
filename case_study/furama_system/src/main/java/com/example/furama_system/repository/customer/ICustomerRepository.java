package com.example.furama_system.repository.customer;

import com.example.furama_system.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

    Customer findById(int id);

    @Query(value = "select * from customer where name like %:keywordId% and is_delete = 0", nativeQuery = true)
    Page<Customer> findAllByKey(@Param("keywordId") String search, Pageable pageable);

    @Modifying
    @Query(value = "update customer set is_delete= 1 where id = :keyword", nativeQuery = true)
    void deleteById(@Param("keyword") int id);

    @Query(value = "select * from customer where name like %:keySearch% and is_delete = 0", nativeQuery = true)
    Page<Customer> pageSearch(@Param("keySearch") String name, Pageable pageable);

}
