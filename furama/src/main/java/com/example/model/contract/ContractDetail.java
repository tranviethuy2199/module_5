package com.example.model.contract;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity; // số lượng

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "attachFacility_id")
    private AttachFacility attachFacility;

    public ContractDetail() {
    }

    public ContractDetail(int id, int quantity, Contract contract,
                          AttachFacility attachFacility) {
        this.id = id;
        this.quantity = quantity;
        this.contract = contract;
        this.attachFacility = attachFacility;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
}
