package com.protocolManagement.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_contracts")
public class Contracts implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String entity;
    private String contractNumber;
    private String supplier;
    private String operatingUnit;
    private String cnpj;

    public Contracts(){}

    public Contracts(Long id, String entity, String contractNumber, String supplier, String operatingUnit, String cnpj) {
        this.id = id;
        this.entity = entity;
        this.contractNumber = contractNumber;
        this.supplier = supplier;
        this.operatingUnit = operatingUnit;
        this.cnpj = cnpj;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getOperatingUnit() {
        return operatingUnit;
    }

    public void setOperatingUnit(String operatingUnit) {
        this.operatingUnit = operatingUnit;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contracts contracts)) return false;
        return id.equals(contracts.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
