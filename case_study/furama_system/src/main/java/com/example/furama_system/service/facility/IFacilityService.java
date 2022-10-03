package com.example.furama_system.service.facility;

import com.example.furama_system.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    Page<Facility> findByNameContaining(String search, Pageable pageable);

    void save(Facility facility);

    Facility findById(int id);

    void update(Facility facility);

    void remove(int id);

    List<Facility> findAll();
}
