package com.example.test.service.impl;

import com.example.test.model.Product;
import com.example.test.repository.IProductRepository;
import com.example.test.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;


    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void remove(int id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public Page<Product> findAllByName(String nameSearch, String priceSearch, String typeSearch, org.springframework.data.domain.Pageable pageable) {
        return iProductRepository.searchByName(nameSearch,priceSearch,typeSearch,pageable);
    }
}
