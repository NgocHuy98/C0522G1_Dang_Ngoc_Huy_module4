package com.example.validate_form.service.impl;

import com.example.validate_form.model.Validator;
import com.example.validate_form.repository.IValidateRepository;
import com.example.validate_form.service.IValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidateService implements IValidateService {
    @Autowired
    private IValidateRepository iValidateRepository;


    @Override
    public List<Validator> findAll() {
        return iValidateRepository.findAll();
    }

    @Override
    public void save(Validator validator) {
        iValidateRepository.save(validator);
    }
}
