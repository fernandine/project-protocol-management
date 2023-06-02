package com.protocolManagement.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.protocolManagement.backend.entities.enums.EntityType;
import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Contracts.class, name = "contracts"),
        @JsonSubTypes.Type(value = Accounting.class, name = "accounting"),
        @JsonSubTypes.Type(value = CollectiveLaborAgreement.class, name = "collectiveLaborAgreement"),
        @JsonSubTypes.Type(value = FinancialReport.class, name = "financialReport"),
        @JsonSubTypes.Type(value = FiscalDocument.class, name = "fiscalDocument"),
        @JsonSubTypes.Type(value = FunctionalFolder.class, name = "functionalFolder"),
        @JsonSubTypes.Type(value = InternationalCertification.class, name = "internationalCertification"),
        @JsonSubTypes.Type(value = MedicalRecord.class, name = "medicalRecord"),
        @JsonSubTypes.Type(value = SelectionProcess.class, name = "selectionProcess"),
        @JsonSubTypes.Type(value = Supplies.class, name = "supplies"),
        @JsonSubTypes.Type(value = TechnicalReport.class, name = "technicalReport"),
})
public abstract class DocumentType implements Serializable {

    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    private EntityType entity;

    @JsonIgnore
    @OneToOne
    @MapsId
    @JoinColumn(name = "protocol_id")
    private Protocol protocol;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EntityType getEntity() {
        return entity;
    }

    public void setEntity(EntityType entity) {
        this.entity = entity;
    }

    public Protocol getProtocol() {
        return protocol;
    }

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentType that = (DocumentType) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

