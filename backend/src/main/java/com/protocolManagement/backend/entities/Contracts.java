package com.protocolManagement.backend.entities;

import com.fasterxml.jackson.annotation.JsonTypeName;
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

    @Column(name = "contract_number")
    private String contractNumber;
    private String supplier;
    @Column(name = "operating_unit")
    private String operatingUnit;
    @NotNull
    private String cnpj;

}
