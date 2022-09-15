package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import com.mysql.cj.xdevapi.SessionFactory;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.Configuration;
import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;



    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
       productRepository.save(product);
    }

//    @Override
//    public Product findById(int id) {
//        return productRepository.findById(id);
//    }
//
//    @Override
//    public void update(int id, Product product) {
//       productRepository.update(id, product);
//
//    }
//
//    @Override
//    public void remove(int id) {
//        productRepository.remove(id);
//    }
//
//    @Override
//    public List<Product> findByName(String name) {
//        return productRepository.findByName(name);
//    }


}
