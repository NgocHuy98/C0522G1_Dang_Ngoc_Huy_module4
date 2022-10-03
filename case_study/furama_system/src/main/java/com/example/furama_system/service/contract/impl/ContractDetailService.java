package com.example.furama_system.service.contract.impl;

import com.example.furama_system.model.ContractDetail;
import com.example.furama_system.repository.contract.IContractDetailRepository;
import com.example.furama_system.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository iContractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return iContractDetailRepository.findAll();
    }
}
