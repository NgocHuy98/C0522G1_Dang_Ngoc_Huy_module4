package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.ConnectionUtil;
import com.codegym.repository.IProductRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
//    private static final Map<Integer, Product> productList;
////
//    static {
//
//        productList = new HashMap<>();
//        productList.put(1, new Product(1, "Ronaldo", 100, "Mr. Champion League", "Portugal"));
//        productList.put(2, new Product(2, "Neymar jr", 220, "Samba dancer", "Brazil"));
//        productList.put(3, new Product(3, "De Bruyne", 200, "Leader", "Belgium"));
//        productList.put(4, new Product(4, "Quang Hai", 90, "Hope", "Việt Nam"));
//        productList.put(5, new Product(5, "Harry Maguire", 80, "Destroyer, Burden", "English"));
//    }

    @Override
    public List<Product> findAll() {
        Session session = null;
        List<Product> productList = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("FROM Product ").getResultList();
        } finally {
            if(session != null){
                session.close();
            }
        }
        return productList;


    }

    @Override
    public void save(Product student) {
        Transaction transaction = null;
        Session session = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(student);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        } finally {
            if(session != null){
                session.close();
            }
        }

    }


//    @Override
//    public Product findById(int id) {
//        Session session = null;
//        List<Product> products = null;
//
//        try {
//            session = ConnectionUtil.sessionFactory.openSession();
//            products = session.createQuery("FROM Product where id = ?").getResultList();
//        } finally {
//            if(session != null){
//                session.close();
//            }
//        }
//        return products;
//    }
//
//    @Override
//    public void update(int id, Product product) {
//        productList.put(id, product);
//
//    }
//
//    @Override
//    public void remove(int id) {
//        productList.remove(id);
//    }
//
//    @Override
//    public List<Product> findByName(String name) {
//        List<Product> products = new ArrayList<>();
//        for (Map.Entry<Integer,Product> item: productList.entrySet()){
//            if(item.getValue().getName().contains(name)){
//                products.add(item.getValue());
//            }
//        }
//        return products;
//    }


}
