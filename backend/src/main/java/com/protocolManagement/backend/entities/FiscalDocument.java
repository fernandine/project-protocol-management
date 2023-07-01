package com.protocolManagement.backend.entities;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.protocolManagement.backend.entities.enums.EntityType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.time.Instant;

@Entity
@Table(name = "tb_fiscal_document")
@JsonTypeName("fiscalDocument")
public class FiscalDocument extends DocumentType {

    @NotNull
    @Column(name = "box_number")
    private Long boxNumber;
    @NotNull
    @Column(name = "guide_type")
    private String guideType;
    @NotNull
    @Column(name = "start_date", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant startDate;
    @NotNull
    @Column(name = "end_date", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant endDate;

    public FiscalDocument(){}

    public FiscalDocument(Long id, EntityType entity, Protocol protocol, Long boxNumber, String guideType, Instant startDate, Instant endDate) {
        super(id, entity, protocol);
        this.boxNumber = boxNumber;
        this.guideType = guideType;
        this.startDate = startDate;
        this.endDate = endDate;
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