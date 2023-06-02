package com.protocolManagement.backend.entities;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.protocolManagement.backend.entities.enums.SupplieType;
import javax.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_supplies")
@JsonTypeName("supplies")
public class Supplies extends DocumentType {

    private SupplieType type;
    @Column (name="date_year", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dateYear;

    public Supplies(){}

    public Supplies( SupplieType type, Instant dateYear) {
        this.type = type;
        this.dateYear = dateYear;
    }

    public SupplieType getType() {
        return type;
    }

    public void setType(SupplieType type) {
        this.type = type;
    }

    public Instant getDateYear() {
        return dateYear;
    }

    public void setDateYear(Instant dateYear) {
        this.dateYear = dateYear;
    }
}
