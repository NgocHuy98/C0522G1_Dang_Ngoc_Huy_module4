package com.example.furama_system.service.employee.impl;

import com.example.furama_system.model.Division;
import com.example.furama_system.repository.employee.IDivisionRepository;
import com.example.furama_system.service.employee.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    private IDivisionRepository iDivisionRepository;

    @Override
    public List<Division> findAll() {
        return iDivisionRepository.findAll();
    }
}