package com.example.validate_form.service;

import com.example.validate_form.model.Validator;
import java.util.List;

public interface IValidateService {

    List<Validator> findAll();

    void save(Validator validator);
}
