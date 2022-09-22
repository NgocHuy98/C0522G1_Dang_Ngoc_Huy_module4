package com.example.borrow_book.repository;

import com.example.borrow_book.model.Library;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILibraryRepository extends JpaRepository<Library,Integer> {
    Page<Library> findByNameContaining(String search, Pageable pageable);


}
