package com.protocolManagement.backend.entities;

import com.fasterxml.jackson.annotation.JsonTypeName;
import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_technical_report")
@JsonTypeName("technicalReport")
public class TechnicalReport extends DocumentType {

    @Column(name = "box_number")
    private Long boxNumber;
    @Column(name = "project_name")
    private String projectName;
    @Column (columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant period;

    public TechnicalReport(){}

    public TechnicalReport( Long boxNumber, String projectName, Instant period) {
        this.boxNumber = boxNumber;
        this.projectName = projectName;
        this.period = period;
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
