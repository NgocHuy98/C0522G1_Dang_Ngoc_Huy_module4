package com.example.furama_system.service.employee.impl;

import com.example.furama_system.model.EducationDegree;
import com.example.furama_system.repository.employee.IEducationDegreeRepository;
import com.example.furama_system.service.employee.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeService implements IEducationDegreeService {

    @Autowired
    private IEducationDegreeRepository iEducationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return iEducationDegreeRepository.findAll();
    }
}
