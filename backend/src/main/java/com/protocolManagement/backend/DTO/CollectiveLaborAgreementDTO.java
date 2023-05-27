package com.protocolManagement.backend.DTO;

import java.io.Serializable;
import java.time.Instant;

public class CollectiveLaborAgreementDTO implements Serializable {
    private Long id;
    private String entity;
    private Long boxNumber;
    private Long numberProcess;
    private String company;
    private Instant year;

    public CollectiveLaborAgreementDTO() {
    }

    public CollectiveLaborAgreementDTO(Long id, String entity, Long boxNumber, Long numberProcess, String company, Instant year) {
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
}
