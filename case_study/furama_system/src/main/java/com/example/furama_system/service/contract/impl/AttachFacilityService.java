package com.example.furama_system.service.contract.impl;

import com.example.furama_system.repository.contract.IAttachFacilityRepository;
import com.example.furama_system.service.contract.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    private IAttachFacilityRepository iAttachFacilityRepository;
}
