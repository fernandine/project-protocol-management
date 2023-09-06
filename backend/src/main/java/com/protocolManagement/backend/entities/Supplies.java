package com.protocolManagement.backend.entities;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.protocolManagement.backend.entities.enums.EntityType;
import com.protocolManagement.backend.entities.enums.SupplieType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

import java.time.Instant;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_supplies")
@JsonTypeName("supplies")
public class Supplies extends DocumentType {

    @Column(name = "supplie_type")
    private SupplieType supplieType;
    @Pattern(regexp = "\\d{4}")
    @Column (name = "date_year")
    private String dateYear;
}