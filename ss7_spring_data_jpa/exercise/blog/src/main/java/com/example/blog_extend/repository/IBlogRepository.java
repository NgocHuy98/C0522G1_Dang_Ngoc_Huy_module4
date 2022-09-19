package com.example.blog_extend.repository;

import com.example.blog_extend.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Blog findById(int id);

//    @Query(value = "select * from Blog where tittle like %:keyword%", nativeQuery = true)
//    Page<Blog> searchByName(@Param("keyword") String name, org.springframework.data.domain.Pageable pageable);


    @Query(value = "select * from Blog where tittle like %:keyword%", nativeQuery = true)
    Page<Blog> searchByName(@Param("keyword") String name, Pageable pageable);

    @Query(value = "select  * from Blog order by date_writing DESC ", nativeQuery = true)
    Page<Blog> findAll(Pageable pageable);
}
