package com.example.furama_system.service.employee.impl;

import com.example.furama_system.model.Position;
import com.example.furama_system.repository.employee.IPositionRepository;
import com.example.furama_system.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepository iPositionRepository;

    @Override
    public List<Position> findAll() {
        return iPositionRepository.findAll();
    }
}