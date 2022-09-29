package com.example.blog_intel.repository;


import com.example.blog_intel.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

@Query(value = "select * from blog where tittle like %:key%",nativeQuery = true)
    List<Blog> findBlog(@Param("key") String search);

    Blog findById(int id);

}
