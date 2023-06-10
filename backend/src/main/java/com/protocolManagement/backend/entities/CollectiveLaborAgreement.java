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
@Table(name = "tb_collective_labor_agreement")
@JsonTypeName("collectiveLaborAgreement")
public class CollectiveLaborAgreement extends DocumentType {

    @Column(name = "box_number")
    private Long boxNumber;

    private String company;
    @Column (name = "date_year", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dateYear;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OrderBy("id ASC")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "protocol_id", nullable = false)
    private Protocol protocol;
}
