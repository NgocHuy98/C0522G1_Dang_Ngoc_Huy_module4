package com.example.furama_system.service.facility.impl;

import com.example.furama_system.model.FacilityType;
import com.example.furama_system.repository.facility.IFacilityTypeRepository;
import com.example.furama_system.repository.facility.IRenTypeRepository;
import com.example.furama_system.service.facility.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeService  implements IFacilityTypeService {
    @Autowired
    private IFacilityTypeRepository iFacilityTypeRepository;

    @Override
    public List<FacilityType> findAll() {
        return iFacilityTypeRepository.findAll();
    }
}
