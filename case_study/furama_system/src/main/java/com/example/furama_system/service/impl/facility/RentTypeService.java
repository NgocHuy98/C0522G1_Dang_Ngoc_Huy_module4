package com.example.furama_system.service.impl.facility;

import com.example.furama_system.model.RentType;
import com.example.furama_system.repository.facility.IRenTypeRepository;
import com.example.furama_system.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRenTypeRepository iRenTypeRepository;

    @Override
    public List<RentType> findAll() {
        return iRenTypeRepository.findAll();
    }
}
