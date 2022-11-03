package com.example.test.repository;

import com.example.test.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {



    @Query(value = "select * " +
            "from product " +
            "where name like %:keywordName% " +
            "and price like %:keywordPrice% " +
            "and product_type_id like %:keywordType% " +
            "and is_delete=0", nativeQuery = true)
    Page<Product> searchByName(@Param("keywordName") String nameSearch,
                               @Param("keywordPrice") String priceSearch,
                               @Param("keywordType") String typeSearch, Pageable pageable);

    @Modifying
    @Query(value = "update product set is_delete = 1 where id = :keyword", nativeQuery = true)
    void deleteById(@Param("keyword") int id);
}
