package com.example.furama_system.service.contract.impl;

import com.example.furama_system.dto.IContractDto;
import com.example.furama_system.model.Contract;
import com.example.furama_system.repository.contract.IContractRepository;
import com.example.furama_system.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;


    @Override
    public Page<IContractDto> findAllContract(Pageable pageable) {
        return iContractRepository.findAllByName(pageable);
    }
}
