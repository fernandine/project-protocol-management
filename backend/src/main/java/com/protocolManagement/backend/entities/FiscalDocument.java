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
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant period;

    public FiscalDocument(){}

    public FiscalDocument(Long id, EntityType entity, Protocol protocol, Long boxNumber,
                          String guideType, Instant period) {
        super(id, entity, protocol);
        this.boxNumber = boxNumber;
        this.guideType = guideType;
        this.period = period;
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