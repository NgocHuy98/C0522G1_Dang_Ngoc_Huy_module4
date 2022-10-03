package com.example.furama_system.repository.contract;

import com.example.furama_system.model.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttachFacilityRepository extends JpaRepository<AttachFacility, Integer> {
}
