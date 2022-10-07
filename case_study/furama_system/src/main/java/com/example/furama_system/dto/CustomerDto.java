package com.example.furama_system.dto;

import com.example.furama_system.model.Contract;
import com.example.furama_system.model.CustomerType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

public class CustomerDto {
    private int id;

    @NotBlank
    @Size(min = 3, max = 100, message = "5 or more characters (< 100)")
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Each first letter must be capitalized (ex: Jack...)")
    private String name;

    private int gender;

    @NotBlank
    private String dateOfBirth;

    @Pattern(regexp = "\\d{9}|\\d{12}",message = "Identity card must be in the correct format of 9 and 12 numbers")
    private String idCard;

    @Pattern(regexp = "^((\\(\\+84\\-\\))|0)(90|91)[0-9]{7}$",message = "Include ten number: 090|091-xxxxxxx" )
    private String phone;

    @Email(message = "Wrong email format, please enter correct email! (ex: abc@example.com")
    private String email;

    @NotBlank()
    @Size(max = 100,message = "characters (< 100)")
    private String address;

    private boolean isDelete;

    private CustomerType customerType;

    private Set<Contract> contractSet;

    public CustomerDto() {
    }

    public CustomerDto(int id, String name, int gender, String dateOfBirth, String idCard, String phone,
                    String email, String address, CustomerType customerType) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
