package com.protocolManagement.backend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.protocolManagement.backend.entities.enums.EntityType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.time.Instant;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_accounting")
@JsonTypeName("accounting")
public class Accounting extends DocumentType {

    @Column(name = "number_document")
    private Long numberDocument;
    @Column(name = "invoice_value")
    private Double invoiceValue;
    @Column (columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant discharge;
    @Column(name = "number_pay")
    private Long numberPay;
    private Long bordero;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OrderBy("id ASC")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "protocol_id", nullable = false)
    private Protocol protocol;

}
