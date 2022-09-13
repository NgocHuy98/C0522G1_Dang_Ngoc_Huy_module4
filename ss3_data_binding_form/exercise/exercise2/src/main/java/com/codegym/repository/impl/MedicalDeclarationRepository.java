package com.codegym.repository.impl;

import com.codegym.model.MedicalDeclaration;
import com.codegym.repository.IMedicalDeclarationRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class MedicalDeclarationRepository implements IMedicalDeclarationRepository {


    private static List<MedicalDeclaration> declarations = new ArrayList<>();
    private static List<String> genderList = new ArrayList<>();
    private static List<String> nationList = new ArrayList<>();
    private static List<String> travelList = new ArrayList<>();

    static {
        declarations.add(new MedicalDeclaration(1, "Huy jr", "11/01/1998", "nam", "Việt nam", "1111111", "Xe máy", "43-1234", 1, "01/01/2022", "10/01/2022", "Hội An"));
        declarations.add(new MedicalDeclaration(2, "Hùng", "11/01/1998", "nam", "Việt nam", "11111222", "Xe máy", "43-4444", 2, "01/01/2022", "10/01/2022", "Đà Nẵng"));
        declarations.add(new MedicalDeclaration(3, "Faker", "11/01/1998", "nam", "Việt nam", "11133333", "Xe máy", "43-1222", 3, "01/01/2022", "10/01/2022", "Đà Nẵng"));

        genderList.add("nam");
        genderList.add("nữ");
        genderList.add("LGBT");

        travelList.add("Máy bay");
        travelList.add("Ô tô");
        travelList.add("Tàu thuyền");
        travelList.add("Khác");

        nationList.add("Việt Nam");
        nationList.add("Nhật Bản");
        nationList.add("Bồ Đào Nha");
        nationList.add("Trung quốc");
        nationList.add("Anh");
    }

    @Override
    public List<MedicalDeclaration> findAll() {
        return declarations;
    }

    @Override
    public List<String> findAllGender() {
        return genderList;
    }

    @Override
    public List<String> findAllNation() {
        return nationList;
    }

    @Override
    public List<String> findAllTravel() {
        return travelList;
    }

    @Override
    public void create(MedicalDeclaration declaration) {
        declarations.add(declaration);
    }

//
//    @Override
//    public void save(MedicalDeclaration declaration) {
//        declarations.add(declaration);
//    }

    @Override
    public MedicalDeclaration findById(int id) {
        for (MedicalDeclaration declaration1 : declarations) {
            if (declaration1.getId() == id) {
                return declaration1;
            }
        }
        return null;
    }

    @Override
    public void update(MedicalDeclaration declaration) {
        for (MedicalDeclaration declaration2 : declarations) {
            if (declaration2.getId() == declaration.getId()) {
                declarations.remove(declaration2);
                declarations.add(declaration);
                break;
            }
        }

    }

}
