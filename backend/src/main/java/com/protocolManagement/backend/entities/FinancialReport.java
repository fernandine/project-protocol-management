package com.protocolManagement.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_financial_report")
public class FinancialReport implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String entity;
    private Long numberDocument;
    private Long value;
    @Column (columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant discharge;
    private Long numberPay;
    private Long bordero;

    public FinancialReport(){}

    public FinancialReport(Long id, String entity, Long numberDocument, Long value, Instant discharge, Long numberPay, Long bordero) {
        this.id = id;
        this.entity = entity;
        this.numberDocument = numberDocument;
        this.value = value;
        this.discharge = discharge;
        this.numberPay = numberPay;
        this.bordero = bordero;
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

    public Long getNumberDocument() {
        return numberDocument;
    }

    public void setNumberDocument(Long numberDocument) {
        this.numberDocument = numberDocument;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FinancialReport that)) return false;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}