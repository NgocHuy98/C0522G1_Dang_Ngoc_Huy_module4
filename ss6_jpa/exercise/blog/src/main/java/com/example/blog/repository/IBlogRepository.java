package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Blog findById(int id);

    @Query(value = "select * from Blog where tittle like %:keyword%", nativeQuery = true)
    List<Blog> searchByName(@Param("keyword") String name);
}
