package com.protocolManagement.backend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.protocolManagement.backend.entities.enums.EntityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_protocol")
public class Protocol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("_id")
    private Long id;

    private String protocolNumber;

    @Enumerated(EnumType.STRING)
    private EntityType institution;
    @NotBlank
    @NotNull
    private String management;
    @NotNull
    private String operatingUnit;

    @NotNull
    @NotEmpty
    @Valid
    @OneToMany(mappedBy = "protocol", cascade = CascadeType.MERGE)
    private List<DocumentType> documents;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Protocol() {}

    public Protocol(Long id, String protocolNumber, EntityType institution, String management, String operatingUnit, User user) {
        this.id = id;
        this.protocolNumber = protocolNumber;
        this.institution = institution;
        this.management = management;
        this.operatingUnit = operatingUnit;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProtocolNumber() {
        return protocolNumber;
    }

    public void setProtocolNumber(String protocolNumber) {
        this.protocolNumber = protocolNumber;
    }

    public EntityType getInstitution() {
        return institution;
    }

    public void setInstitution(EntityType institution) {
        this.institution = institution;
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

    public List<DocumentType> getDocuments() {
        return documents;
    }

    public void setDocuments(List<DocumentType> documents) {
        this.documents = documents;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Protocol protocol)) return false;
        return Objects.equals(id, protocol.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
