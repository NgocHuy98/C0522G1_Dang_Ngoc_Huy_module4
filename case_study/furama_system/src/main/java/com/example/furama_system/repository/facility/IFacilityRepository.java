package com.example.furama_system.repository.facility;

import com.example.furama_system.model.Customer;
import com.example.furama_system.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    Facility findById(int id);

    Page<Facility> findByNameContaining(String search, Pageable pageable);
}
