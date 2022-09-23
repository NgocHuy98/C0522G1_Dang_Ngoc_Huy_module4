package com.example.cart.repository;

import com.example.cart.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {

   Optional <Product> findById(int id);

    Page<Product> findByNameContaining(String search, Pageable pageable);
}
