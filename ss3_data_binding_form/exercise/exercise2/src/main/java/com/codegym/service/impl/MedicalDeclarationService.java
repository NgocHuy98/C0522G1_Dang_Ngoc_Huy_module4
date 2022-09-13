package com.codegym.service.impl;

import com.codegym.model.MedicalDeclaration;
import com.codegym.repository.IMedicalDeclarationRepository;
import com.codegym.service.IMedicalDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalDeclarationService implements IMedicalDeclarationService {

    @Autowired
    private IMedicalDeclarationRepository declarationRepository;

    @Override
    public List<MedicalDeclaration> findAll() {
        return declarationRepository.findAll();
    }

    @Override
    public List<String> findAllGender() {
        return declarationRepository.findAllGender();
    }

    @Override
    public List<String> findAllNation() {
        return declarationRepository.findAllNation();
    }

    @Override
    public List<String> findAllTravel() {
        return declarationRepository.findAllTravel();
    }

    @Override
    public void create(MedicalDeclaration declaration) {
        declarationRepository.create(declaration);
    }


//    @Override
//    public void save(MedicalDeclaration declaration) {
//        declarationRepository.save(declaration);
//    }

    @Override
    public MedicalDeclaration findById(int id) {
        return declarationRepository.findById(id);
    }

    @Override
    public void update(MedicalDeclaration declaration) {
        declarationRepository.update(declaration);
    }
}
