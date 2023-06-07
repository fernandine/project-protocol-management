package com.protocolManagement.backend.entities;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.protocolManagement.backend.entities.enums.EntityType;

import javax.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_collective_labor_agreement")
@JsonTypeName("collectiveLaborAgreement")
public class CollectiveLaborAgreement extends DocumentType {

    @Column(name = "box_number")
    private Long boxNumber;
    @Column(name = "number_process")
    private Long numberProcess;
    private String company;
    @Column (name = "date_year", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dateYear;

    public CollectiveLaborAgreement(){}

    public CollectiveLaborAgreement(Long id, EntityType entity, Protocol protocol, Long boxNumber, Long numberProcess, String company, Instant dateYear) {
        super(id, entity, protocol);
        this.boxNumber = boxNumber;
        this.numberProcess = numberProcess;
        this.company = company;
        this.dateYear = dateYear;
    }

    public Long getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(Long boxNumber) {
        this.boxNumber = boxNumber;
    }

    public Long getNumberProcess() {
        return numberProcess;
    }

    public void setNumberProcess(Long numberProcess) {
        this.numberProcess = numberProcess;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Instant getDateYear() {
        return dateYear;
    }

    public void setDateYear(Instant dateYear) {
        this.dateYear = dateYear;
    }
}
