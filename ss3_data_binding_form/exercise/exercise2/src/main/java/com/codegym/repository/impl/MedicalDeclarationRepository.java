package com.codegym.repository.impl;

import com.codegym.model.MedicalDeclaration;
import com.codegym.repository.IMedicalDeclarationRepository;

import java.util.ArrayList;
import java.util.List;

public class MedicalDeclarationRepository implements IMedicalDeclarationRepository {


    private static List<MedicalDeclaration> declarations = new ArrayList<>();

    static {
        declarations.add(new MedicalDeclaration(1, "Huy jr", "11/01/1998", "nam", "Việt nam", "1111111", "Xe máy", "51H-1057", 1, "01/01/2022", "10/01/2022", "Hội An"));
        declarations.add(new MedicalDeclaration(2, "Hùng", "11/01/1998", "nam", "Việt nam", "11111222", "Xe máy", "51H-1057", 2, "01/01/2022", "10/01/2022", "Đà Nẵng"));
        declarations.add(new MedicalDeclaration(3, "Faker", "11/01/1998", "nam", "Việt nam", "11133333", "Xe máy", "51H-1057", 3, "01/01/2022", "10/01/2022", "Đà Nẵng"));

    }

    @Override
    public List<MedicalDeclaration> displayAll() {
        return declarations;
    }

    @Override
    public MedicalDeclaration finById(int id) {
        return declarations.get(id);
    }

    @Override
    public MedicalDeclaration edit(MedicalDeclaration medicalDeclaration) {
        MedicalDeclaration declaration = finById(medicalDeclaration.getId());
        declaration.setName(medicalDeclaration.getName());
        declaration.setDayOfBirth(medicalDeclaration.getDayOfBirth());
        declaration.setNationality(medicalDeclaration.getNationality());
        declaration.setEndDate(medicalDeclaration.getEndDate());
        declaration.setGender(medicalDeclaration.getGender());
        declaration.setIdCard(medicalDeclaration.getIdCard());
        declaration.setVehicleNumber(medicalDeclaration.getVehicleNumber());
        declaration.setStartDate(medicalDeclaration.getStartDate());
        declaration.setSeatNumber(medicalDeclaration.getSeatNumber());
        declaration.setTravelHistory(medicalDeclaration.getTravelHistory());
        declaration.setTravelInformation(medicalDeclaration.getTravelInformation());
        return declaration;
    }

   
}
