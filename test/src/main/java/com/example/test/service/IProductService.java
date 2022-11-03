package com.example.test.service;

import com.example.test.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {


    void save(Product product);

    Product findById(int id);

    void update(Product product);

    void remove(int id);

    Page<Product> findAllByName(String nameSearch, String priceSearch, String typeSearch, Pageable pageable);
}
