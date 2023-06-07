package com.protocolManagement.backend.entities;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.protocolManagement.backend.entities.enums.EntityType;
import com.protocolManagement.backend.entities.enums.SupplieType;
import javax.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_supplies")
@JsonTypeName("supplies")
public class Supplies extends DocumentType {

    @Column(name = "supplie_type")
    private SupplieType supplieType;
    @Column (name="date_year", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dateYear;

    public Supplies(){}

    public Supplies(Long id, EntityType entity, Protocol protocol,
                    SupplieType supplieType, Instant dateYear) {
        super(id, entity, protocol);
        this.supplieType = supplieType;
        this.dateYear = dateYear;
    }

    public SupplieType getSupplieType() {
        return supplieType;
    }

    public void setSupplieType(SupplieType supplieType) {
        this.supplieType = supplieType;
    }

    public Instant getDateYear() {
        return dateYear;
    }

    public void setDateYear(Instant dateYear) {
        this.dateYear = dateYear;
    }
}
