package com.example.borrow_book.service.impl;

import com.example.borrow_book.model.Library;
import com.example.borrow_book.repository.ILibraryRepository;
import com.example.borrow_book.service.ILibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LibraryService implements ILibraryService {
    @Autowired
    private ILibraryRepository libraryRepository;


    @Override
    public Page<Library> findByNameContaining(String search, Pageable pageable) {
        return libraryRepository.findByNameContaining(search, pageable);
    }

    @Override
    public void save(Library library) {
        libraryRepository.save(library);
    }

    @Override
    public Library findById(int id) {
        return libraryRepository.getById(id);
    }

    @Override
    public void update(Library library) {
        libraryRepository.save(library);
    }

    @Override
    public void remove(int id) {
        libraryRepository.deleteById(id);
    }
}
