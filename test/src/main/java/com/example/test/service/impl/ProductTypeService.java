package com.example.test.service.impl;

import com.example.test.model.ProductType;
import com.example.test.repository.IProductTypeRepository;
import com.example.test.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService implements IProductTypeService {
    @Autowired
    private IProductTypeRepository iProductTypeRepository;

    @Override
    public List<ProductType> findAll() {
        return iProductTypeRepository.findAll();
    }
}
