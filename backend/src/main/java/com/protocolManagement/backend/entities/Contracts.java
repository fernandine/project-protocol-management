package com.protocolManagement.backend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.protocolManagement.backend.entities.enums.EntityType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_contracts")
@JsonTypeName("contracts")
public class Contracts extends DocumentType {
    @NotNull
    @Column(name = "contract_number")
    private String contractNumber;
    @NotNull
    private String supplier;
    @NotNull
    @Column(name = "operating_unit")
    private String operatingUnit;
    @NotNull
    private String cnpj;

}
