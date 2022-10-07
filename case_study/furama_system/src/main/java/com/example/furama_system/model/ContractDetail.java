package com.example.furama_system.model;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "contract_id",referencedColumnName = "id")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "attach_facility_id",referencedColumnName = "id")
    private AttachFacility attachFacility;

    private int quantity;

    private String isDelete;

    public ContractDetail() {
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public ContractDetail(int id, Contract contract, AttachFacility attachFacility, int quantity, String isDelete) {
        this.id = id;
        this.contract = contract;
        this.attachFacility = attachFacility;
        this.quantity = quantity;
        this.isDelete = isDelete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String isDelete() {
        return isDelete;
    }

    public void setDelete(String delete) {
        isDelete = delete;
    }
}
