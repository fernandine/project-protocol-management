package com.protocolManagement.backend.entities;

import com.data.protocolManagement.entities.enums.SupplieType;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_supplies")
public class Supplies implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String entity;
    private SupplieType type;
    @Column (columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant year;

    public Supplies(){}

    public Supplies(Long id, String entity, SupplieType type, Instant year) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Supplies supplies)) return false;
        return id.equals(supplies.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
