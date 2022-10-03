package com.example.furama_system.repository.facility;

import com.example.furama_system.model.Customer;
import com.example.furama_system.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    Facility findById(int id);

    @Query(value = "select * from facility where name like %:key% and is_delete = 0", nativeQuery = true)
    Page<Facility> findAllByKey(@Param("key") String search, Pageable pageable);

    @Modifying
    @Query(value = "update facility set is_delete = 1 where id = :keyword", nativeQuery = true)
    void deleteById(@Param("keyword") int id);
}
