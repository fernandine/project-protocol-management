package com.protocolManagement.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_collective_labor_agreement")
public class CollectiveLaborAgreement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String entity;
    private Long boxNumber;
    private Long numberProcess;
    private String company;
    @Column (columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant year;

    public CollectiveLaborAgreement(){}

    public CollectiveLaborAgreement(Long id, String entity, Long boxNumber, Long numberProcess, String company, Instant year) {
        this.id = id;
        this.entity = entity;
        this.boxNumber = boxNumber;
        this.numberProcess = numberProcess;
        this.company = company;
        this.year = year;
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

    public Instant getYear() {
        return year;
    }

    public void setYear(Instant year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CollectiveLaborAgreement that)) return false;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
