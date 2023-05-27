package com.protocolManagement.backend.DTO;

import com.protocolManagement.backend.entities.enums.SupplieType;
import jakarta.persistence.Column;

import java.io.Serializable;
import java.time.Instant;

public class SuppliesDTO implements Serializable {

    private Long id;
    private String entity;
    private SupplieType type;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant year;

    public SuppliesDTO(){}

    public SuppliesDTO(Long id, String entity, SupplieType type, Instant year) {
        this.id = id;
        this.entity = entity;
        this.type = type;
        this.year = year;
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

    public SupplieType getType() {
        return type;
    }

    public void setType(SupplieType type) {
        this.type = type;
    }

    public Instant getYear() {
        return year;
    }

    public void setYear(Instant year) {
        this.year = year;
    }
}
