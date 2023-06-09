package com.protocolManagement.backend.entities;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.protocolManagement.backend.entities.enums.EntityType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_international_certification")
@JsonTypeName("internationalCertification")
public class InternationalCertification extends DocumentType {
    @NotNull
    @Column(name = "box_number")
    private Long boxNumber;
    @NotNull
    @Column(name = "process_number")
    private String processNumber;
    @NotNull
    private String company;

    public InternationalCertification(){}


    public InternationalCertification(Long id, EntityType entity, Protocol protocol, Long boxNumber, String processNumber, String company) {
        super(id, entity, protocol);
        this.boxNumber = boxNumber;
        this.processNumber = processNumber;
        this.company = company;
    }

    public Long getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(Long boxNumber) {
        this.boxNumber = boxNumber;
    }

    public String getProcessNumber() {
        return processNumber;
    }

    public void setProcessNumber(String processNumber) {
        this.processNumber = processNumber;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

}