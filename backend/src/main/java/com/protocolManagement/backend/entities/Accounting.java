package com.protocolManagement.backend.entities;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.time.Instant;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_accounting")
public class Accounting extends DocumentType{

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
