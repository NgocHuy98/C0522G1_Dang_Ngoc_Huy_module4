package com.example.borrow_book.service;

import com.example.borrow_book.model.Library;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ILibraryService {
    Page<Library> findByNameContaining(String search, Pageable pageable);

    void save(Library library);

    Library findById(int id);

    void update(Library library);

    void remove(int id);
}
