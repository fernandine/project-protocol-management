package com.protocolManagement.backend.entities;

import com.fasterxml.jackson.annotation.JsonTypeName;

import com.protocolManagement.backend.entities.enums.EntityType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_medical_record")
@JsonTypeName("medicalRecord")
public class MedicalRecord extends DocumentType {

    @Column(name = "box_number")
    private Long boxNumber;
    private String employee;
    @Column(name = "start_date", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant startDate;
    @Column(name = "end_date", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant endDate;
}