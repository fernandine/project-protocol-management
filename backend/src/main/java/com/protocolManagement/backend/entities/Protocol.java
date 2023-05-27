package com.protocolManagement.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_medical_record")
public class Protocol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String entity;
    private String management;
    private String operatingUnit;

    private Accounting accounting;
    private CollectiveLaborAgreement collectiveLaborAgreement;
    private Contracts contracts;
    private FinancialReport financialReport;
    private FiscalDocument fiscalDocument;
    private FuncionalFolder funcionalFolder;
    private InternationalCertification internationalCertification;
    private MedicalRecord medicalRecord;
    private SelectionProcess selectionProcess;
    private User user;

    public Protocol(){}

    public Protocol(Long id, String entity, String management, String operatingUnit) {
        this.id = id;
        this.entity = entity;
        this.management = management;
        this.operatingUnit = operatingUnit;
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

    public String getManagement() {
        return management;
    }

    public void setManagement(String management) {
        this.management = management;
    }

    public String getOperatingUnit() {
        return operatingUnit;
    }

    public void setOperatingUnit(String operatingUnit) {
        this.operatingUnit = operatingUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Protocol protocol)) return false;
        return id.equals(protocol.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
