package com.example.cart.service.impl;

import com.example.cart.model.Product;
import com.example.cart.repository.IProductRepository;
import com.example.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Page<Product> findByNameContaining(String search, Pageable pageable) {
        return iProductRepository.findByNameContaining(search, pageable);
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Optional<Product> findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void remove(int id) {
        iProductRepository.deleteById(id);
    }


}
