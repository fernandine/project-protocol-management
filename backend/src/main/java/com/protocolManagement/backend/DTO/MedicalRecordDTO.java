package com.protocolManagement.backend.DTO;

import java.io.Serializable;
import java.time.Instant;

public class MedicalRecordDTO implements Serializable {

    private Long id;
    private String entity;
    private Long boxNumber;
    private String employee;
    private Instant period;

    public MedicalRecordDTO(){}

    public MedicalRecordDTO(Long id, String entity, Long boxNumber, String employee, Instant period) {
        this.id = id;
        this.entity = entity;
        this.boxNumber = boxNumber;
        this.employee = employee;
        this.period = period;
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

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public Instant getPeriod() {
        return period;
    }

    public void setPeriod(Instant period) {
        this.period = period;
    }
}
