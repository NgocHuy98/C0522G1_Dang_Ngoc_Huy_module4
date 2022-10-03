package com.example.furama_system.service.contract;

import com.example.furama_system.dto.IContractDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {


    Page<IContractDto> findAllContract(Pageable pageable);
}
