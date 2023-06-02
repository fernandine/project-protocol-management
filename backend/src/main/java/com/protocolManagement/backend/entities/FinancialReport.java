package com.protocolManagement.backend.entities;

import com.fasterxml.jackson.annotation.JsonTypeName;
import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
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

    public FinancialReport(){}

    public FinancialReport( Long numberDocument, Double invoiceValue, Instant discharge, Long numberPay, Long bordero) {
        this.numberDocument = numberDocument;
        this.invoiceValue = invoiceValue;
        this.discharge = discharge;
        this.numberPay = numberPay;
        this.bordero = bordero;
    }

    public Long getNumberDocument() {
        return numberDocument;
    }

    public void setNumberDocument(Long numberDocument) {
        this.numberDocument = numberDocument;
    }

    public Double getInvoiceValue() {
        return invoiceValue;
    }

    public void setInvoiceValue(Double invoiceValue) {
        this.invoiceValue = invoiceValue;
    }

    public Instant getDischarge() {
        return discharge;
    }

    public void setDischarge(Instant discharge) {
        this.discharge = discharge;
    }

    public Long getNumberPay() {
        return numberPay;
    }

    public void setNumberPay(Long numberPay) {
        this.numberPay = numberPay;
    }

    public Long getBordero() {
        return bordero;
    }

    public void setBordero(Long bordero) {
        this.bordero = bordero;
    }

}
