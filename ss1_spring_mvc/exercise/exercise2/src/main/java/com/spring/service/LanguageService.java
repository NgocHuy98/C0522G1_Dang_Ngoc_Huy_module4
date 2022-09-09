package com.spring.service;

import com.spring.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LanguageService implements ILanguageService{

    @Autowired
    IRepository iRepository;
    @Override
    public String translate(String english) {
        return iRepository.translate(english);
    }
}
