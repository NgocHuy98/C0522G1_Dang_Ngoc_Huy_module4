package com.example.validate_form.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class ValidateDto implements Validator {

    private int id;

    @NotBlank(message = "Cannot be left blank")
    @Size(min = 5, max = 45, message = "min: character, max: 45 character")
    private String firstName;

    @NotBlank(message = "Cannot be left blank")
    @Size(min = 5, max = 45, message = "min: character, max: 45 character")
    private String lastName;

    @Pattern(regexp = "[0][0-9]{9}",message = "Must input 0xxxxxxxxx, number from 0 to 9")
    private String phoneNumber;

    @Max(value = 70,message = "Age must be less than 70")
    @Min(value = 18,message = "Age must be more than 18")
    private int age;

    @Pattern(regexp = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]{2,}(\\.[A-Za-z0-9]{2,}){1,2}$",
            message = "Email must be in the correct format")
    private String email;

    public ValidateDto() {
    }

    public ValidateDto(int id, String firstName, String lastName, String phoneNumber, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidateDto validateDto = (ValidateDto) target;
        if("admin@gmail.com".equals(validateDto.getEmail())){
            errors.rejectValue("email","","Don't Use Admin");
        }
    }
}
