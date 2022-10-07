package com.example.furama_system.dto;

import com.example.furama_system.model.Contract;
import com.example.furama_system.model.Division;
import com.example.furama_system.model.EducationDegree;
import com.example.furama_system.model.Position;

import javax.validation.constraints.*;
import java.util.Set;

public class EmployeeDto {

    private int id;
    @NotBlank
    @Size(min = 3, max = 100, message = "5 or more characters (< 100)")
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Each first letter must be capitalized (ex: Jack...)")
    private String nameEmployee;

    @NotBlank
    private String dateOfBirth;

    @Pattern(regexp = "\\d{9}|\\d{12}",message = "Identity card must be in the correct format of 9 and 12 numbers")
    private String idCard;

    @Min(value = 4500000,message = "min salary is 4500000")
    private double salary;

    @Pattern(regexp = "^((\\(\\+84\\-\\))|0)(90|91)[0-9]{7}$",message = "Include ten number: 090|091-xxxxxxx" )
    private String phoneNumber;

    @Email(message = "Wrong email format, please enter correct email! (ex: abc@example.com")
    private String email;

    @NotBlank()
    @Size(max = 100,message = "characters (< 100)")
    private String address;

    private boolean isDelete;

    private Position position;

    private EducationDegree educationDegree;

    private Division division;


    private Set<Contract> contractSet;

    public EmployeeDto() {
    }

    public EmployeeDto(int id, String nameEmployee, String dateOfBirth, String idCard,
                       double salary, String phoneNumber, String email, String address,
                       Position position, EducationDegree educationDegree, Division division,
                       Set<Contract> contractSet) {
        this.id = id;
        this.nameEmployee = nameEmployee;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.contractSet = contractSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }
}
