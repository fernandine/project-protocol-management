package com.protocolManagement.backend.entities;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.protocolManagement.backend.entities.enums.EntityType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_technical_report")
@JsonTypeName("technicalReport")
public class TechnicalReport extends DocumentType {

    @NotNull
    @Column(name = "box_number")
    private Long boxNumber;
    @NotNull
    @Column(name = "project_name")
    private String projectName;
    @NotNull
    @Column(name = "start_date", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant startDate;
    @NotNull
    @Column(name = "end_date", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant endDate;

    public TechnicalReport(){}

    public TechnicalReport(Long id, EntityType entity, Protocol protocol, Long boxNumber, String projectName, Instant startDate, Instant endDate) {
        super(id, entity, protocol);
        this.boxNumber = boxNumber;
        this.projectName = projectName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(Long boxNumber) {
        this.boxNumber = boxNumber;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
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