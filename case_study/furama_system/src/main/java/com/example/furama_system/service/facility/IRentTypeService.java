package com.example.furama_system.service.facility;

import com.example.furama_system.model.RentType;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IRentTypeService {
    List<RentType> findAll();
}
