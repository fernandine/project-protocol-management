package com.protocolManagement.backend.DTO;

import jakarta.persistence.Column;

import java.io.Serializable;
import java.time.Instant;

public class TechnicalReportDTO implements Serializable {

    private Long id;
    private String entity;
    private Long boxNumber;
    private String projectName;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant period;

    public TechnicalReportDTO(){}

    public TechnicalReportDTO(Long id, String entity, Long boxNumber, String projectName, Instant period) {
        this.id = id;
        this.entity = entity;
        this.boxNumber = boxNumber;
        this.projectName = projectName;
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Instant getPeriod() {
        return period;
    }

    public void setPeriod(Instant period) {
        this.period = period;
    }
}
