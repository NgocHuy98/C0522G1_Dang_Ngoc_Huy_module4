package com.example.furama_system.dto;

import com.example.furama_system.model.Contract;
import com.example.furama_system.model.FacilityType;
import com.example.furama_system.model.RentType;

import javax.validation.constraints.*;
import java.util.Set;

public class FacilityDto {
    private int id;

    @NotBlank
    @Size(min = 3, max = 100, message = "5 or more characters (< 100)")
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Each first letter must be capitalized (ex: Jack...)")
    private String name;

    @NotBlank
    @Min(40)
    @Max(100)
    private String area;

    @NotBlank
    @Pattern(regexp = "[0-9]+")
    private String cost;

    private String maxPeople;

    private RentType rentType;

    private FacilityType facilityType;

    private String standardRoom;

    private String descriptionOtherConvenience;

    private String poolArea;

    private String numberOfFloors;

    private String facilityFree;

    private Set<Contract> contractSet;

    private boolean isDelete;

    public FacilityDto() {
    }

    public FacilityDto(int id, String name, String area, String cost, String maxPeople, RentType rentType, FacilityType facilityType,
                       String standardRoom, String descriptionOtherConvenience,
                       String poolArea, String numberOfFloors, String facilityFree, Set<Contract> contractSet) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
        this.facilityType = facilityType;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.facilityFree = facilityFree;
        this.contractSet = contractSet;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(String maxPeople) {
        this.maxPeople = maxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }
}
