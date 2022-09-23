package com.example.cart.service;

import com.example.cart.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService {
    Page<Product> findByNameContaining(String search, Pageable pageable);

    void save(Product product);

    void remove(int id);

    Optional<Product> findById(int id);
}
