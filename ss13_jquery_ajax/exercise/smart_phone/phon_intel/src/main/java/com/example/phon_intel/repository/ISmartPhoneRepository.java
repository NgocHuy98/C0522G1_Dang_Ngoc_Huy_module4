package com.example.phon_intel.repository;

import com.example.phon_intel.model.SmartPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartPhoneRepository extends JpaRepository<SmartPhone, Long> {

}