package com.example.furama_system.repository.employee;

import com.example.furama_system.model.EducationDegree;
import com.example.furama_system.model.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducationDegreeRepository extends JpaRepository<EducationDegree, Integer> {
}
