package com.spring.service.impl;

import com.spring.repository.ILanguageRepository;
import com.spring.service.ILanguageService;
import org.springframework.beans.factory.annotation.Autowired;

public class LanguageService implements ILanguageService {

    @Autowired
    ILanguageRepository iRepository;

    @Override
    public String translate(String english) {
        return iRepository.translate(english);
    }
}
