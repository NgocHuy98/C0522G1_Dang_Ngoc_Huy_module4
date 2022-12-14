package com.example.furama_system.dto;

import com.example.furama_system.model.ContractDetail;
import com.example.furama_system.model.Customer;
import com.example.furama_system.model.Employee;
import com.example.furama_system.model.Facility;

import java.util.Set;

public class ContractDto {

    private int id;

    private String startDate;

    private String endDate;

    private String deposit;

    private Employee employee;

    private Customer customer;

    private Facility facility;

    private String isDelete;
    private Set<ContractDetail> contractDetailSet;


    public ContractDto() {
    }

    public ContractDto(int id, String startDate, String endDate, String deposit, Employee employee,
                    Customer customer, Facility facility, String isDelete,
                    Set<ContractDetail> contractDetailSet) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;
        this.isDelete = isDelete;
        this.contractDetailSet = contractDetailSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public Set<ContractDetail> getContractDetailSet() {
        return contractDetailSet;
    }

    public void setContractDetailSet(Set<ContractDetail> contractDetailSet) {
        this.contractDetailSet = contractDetailSet;
    }
}
