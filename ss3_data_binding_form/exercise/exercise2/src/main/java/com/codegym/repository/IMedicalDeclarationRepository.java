package com.codegym.repository;

import com.codegym.model.MedicalDeclaration;

import java.util.List;

public interface IMedicalDeclarationRepository {

    List<MedicalDeclaration> findAll();

    List<String> findAllGender();

    List<String> findAllNation();

    List<String> findAllTravel();

    void create(MedicalDeclaration declaration);

//    void save(MedicalDeclaration declaration);

    MedicalDeclaration findById(int id);

    void update(MedicalDeclaration declaration);
}
