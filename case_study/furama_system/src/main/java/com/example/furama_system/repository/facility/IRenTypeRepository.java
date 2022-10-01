package com.example.furama_system.repository.facility;

import com.example.furama_system.model.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRenTypeRepository extends JpaRepository<RentType, Integer> {
}
