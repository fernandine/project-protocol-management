package com.protocolManagement.backend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.protocolManagement.backend.entities.enums.EntityType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    private String cnpj;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @OrderBy("id ASC")
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    @JoinColumn(name = "protocol_id", nullable = false)
//    private Protocol protocol;

}
