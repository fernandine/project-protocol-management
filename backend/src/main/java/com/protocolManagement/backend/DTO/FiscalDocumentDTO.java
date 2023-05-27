package com.protocolManagement.backend.DTO;

import jakarta.persistence.Column;

import java.io.Serializable;
import java.time.Instant;

public class FiscalDocumentDTO implements Serializable {

    private Long id;
    private String entity;
    private Long boxNumber;
    private String guideType;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant period;

    public FiscalDocumentDTO(){}

    public FiscalDocumentDTO(Long id, String entity, Long boxNumber, String guideType, Instant period) {
        this.id = id;
        this.entity = entity;
        this.boxNumber = boxNumber;
        this.guideType = guideType;
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

    public String getGuideType() {
        return guideType;
    }

    public void setGuideType(String guideType) {
        this.guideType = guideType;
    }

    public Instant getPeriod() {
        return period;
    }

    public void setPeriod(Instant period) {
        this.period = period;
    }
}
