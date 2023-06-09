package com.protocolManagement.backend.entities;

import com.fasterxml.jackson.annotation.JsonTypeName;

import com.protocolManagement.backend.entities.enums.EntityType;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Entity
@Table(name = "tb_medical_record")
@JsonTypeName("medicalRecord")
public class MedicalRecord extends DocumentType {
    @NotNull
    @Column(name = "box_number")
    private Long boxNumber;
    @NotNull
    private String employee;
    @NotNull
    @Column(name = "start_date", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant startDate;
    @NotNull
    @Column(name = "end_date", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant endDate;

    public MedicalRecord(){}

    public MedicalRecord(Long id, EntityType entity, Protocol protocol, Long boxNumber, String employee, Instant startDate, Instant endDate) {
        super(id, entity, protocol);
        this.boxNumber = boxNumber;
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }
}