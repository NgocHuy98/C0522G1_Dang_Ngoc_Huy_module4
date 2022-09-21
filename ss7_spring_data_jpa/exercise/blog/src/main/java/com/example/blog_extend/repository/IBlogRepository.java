package com.example.blog_extend.repository;

import com.example.blog_extend.dto.BlogDto;
import com.example.blog_extend.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    Blog findById(int id);

    @Query(value = "select * from blog where tittle like %:keyword%", nativeQuery = true)
    Page<Blog>findByTittleContaining(@Param("keyword") String search, Pageable pageable);

    @Query(value = "select  * from blog where category_id =:key ", nativeQuery = true)
    Page<Blog> findByAllBlog(@Param("key") int id, Pageable pageable);

//    @Query(value = "select * from Blog where tittle like %:keyword%", nativeQuery = true)
//    Page<Blog> searchByName(@Param("keyword") String name, Pageable pageable);
//
//    @Query(value = "select  * from blog order by date_writing DESC ", nativeQuery = true)
//    Page<Blog> findAll(Pageable pageable);



    @Query(value = "SELECT b.tittle as blogName, c.name as categoryName FROM blog b join category c on b.category_id = c.id order by tittle DESC;",
            nativeQuery= true)
    List<BlogDto> searchByTittle();


}
