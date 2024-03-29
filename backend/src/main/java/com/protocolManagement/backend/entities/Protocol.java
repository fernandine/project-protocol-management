package com.protocolManagement.backend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.protocolManagement.backend.entities.enums.EntityType;

import javax.persistence.*;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_protocol")
public class Protocol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "protocol_number")
    private String protocolNumber;
    @Enumerated(EnumType.STRING)
    private EntityType institution;
    @NotNull
    private String management;
    private String operatingUnit;
    @OneToMany(mappedBy = "protocol", cascade = CascadeType.ALL)
    private List<DocumentType> documents;
    private Boolean received;
    @Column (name = "received_date", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant receivedDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    public Protocol() {}

    public Protocol(Long id, String protocolNumber, EntityType institution, String management, String operatingUnit,
                    Boolean received, Instant receivedDate, User user) {
        this.id = id;
        this.protocolNumber = protocolNumber;
        this.institution = institution;
        this.management = management;
        this.operatingUnit = operatingUnit;
        this.received = received;
        this.receivedDate = receivedDate;
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

    public Boolean isReceived() {
        return received;
    }

    public void setReceived(Boolean received) {
        this.received = received;
    }

    public Instant getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Instant receivedDate) {
        this.receivedDate = receivedDate;
    }

    public Boolean getReceived() {
        return received;
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