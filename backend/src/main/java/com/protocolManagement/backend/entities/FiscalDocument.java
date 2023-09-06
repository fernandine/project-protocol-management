package com.protocolManagement.backend.entities;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.protocolManagement.backend.entities.enums.EntityType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.time.Instant;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_fiscal_document")
@JsonTypeName("fiscalDocument")
public class FiscalDocument extends DocumentType {

    @Column(name = "box_number")
    private Long boxNumber;
    @Column(name = "guide_type")
    private String guideType;
    @Column(name = "start_date", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant startDate;
    @Column(name = "end_date", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant endDate;
}