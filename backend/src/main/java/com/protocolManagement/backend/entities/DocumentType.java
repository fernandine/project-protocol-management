package com.protocolManagement.backend.entities;

import com.fasterxml.jackson.annotation.*;
import com.protocolManagement.backend.entities.enums.EntityType;
import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
@Entity
@Table(name = "tb_document_type")
@Inheritance(strategy= InheritanceType.JOINED)
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
public class DocumentType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private EntityType entity;

    @JsonIgnore
    @ManyToOne
    @OrderBy("id ASC")
    @JoinColumn(name = "protocol_id", nullable = false)
    private Protocol protocol;

    public DocumentType(){}

    public DocumentType(Long id, EntityType entity, Protocol protocol) {
        this.id = id;
        this.entity = entity;
        this.protocol = protocol;
    }
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