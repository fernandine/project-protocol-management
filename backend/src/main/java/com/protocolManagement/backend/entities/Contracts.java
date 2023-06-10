package com.protocolManagement.backend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.protocolManagement.backend.entities.enums.EntityType;

import javax.persistence.*;

@Entity
@Table(name = "tb_contracts")
@JsonTypeName("contracts")
public class Contracts extends DocumentType {

    @Column(name = "contract_number")
    private String contractNumber;
    private String supplier;
    @Column(name = "operating_unit")
    private String operatingUnit;
    private String cnpj;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OrderBy("id ASC")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "protocol_id", nullable = false)
    private Protocol protocol;

    public Contracts(){}

    public Contracts(Long id, EntityType entity, Protocol protocol, String contractNumber, String supplier,
                     String operatingUnit, String cnpj) {
        super(id, entity, protocol);
        this.contractNumber = contractNumber;
        this.supplier = supplier;
        this.operatingUnit = operatingUnit;
        this.cnpj = cnpj;
        this.protocol = protocol;
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
    public Protocol getProtocol() {
        return protocol;
    }

    @Override
    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }
}
