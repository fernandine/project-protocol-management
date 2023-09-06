package com.protocolManagement.backend.entities;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.protocolManagement.backend.entities.enums.EntityType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_financial_report")
@JsonTypeName("financialReport")
public class FinancialReport extends DocumentType {
    @Column(name = "number_document")
    private Long numberDocument;
    @Column(name = "invoice_value")
    private Double invoiceValue;
    @Column (columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant discharge;
    @Column(name = "number_pay")
    private Long numberPay;
    private Long bordero;

}