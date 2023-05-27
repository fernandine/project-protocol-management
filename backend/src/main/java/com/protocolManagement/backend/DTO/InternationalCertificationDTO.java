package com.protocolManagement.backend.DTO;

import java.io.Serializable;

public class InternationalCertificationDTO implements Serializable {

    private Long id;
    private String entity;
    private Long boxNumber;
    private String processNumber;
    private String company;

    public InternationalCertificationDTO(){}

    public InternationalCertificationDTO(Long id, String entity, Long boxNumber, String processNumber, String company) {
        this.id = id;
        this.entity = entity;
        this.boxNumber = boxNumber;
        this.processNumber = processNumber;
        this.company = company;
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
