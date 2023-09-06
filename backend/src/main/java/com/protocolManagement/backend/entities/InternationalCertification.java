package com.protocolManagement.backend.entities;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.protocolManagement.backend.entities.enums.EntityType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_international_certification")
@JsonTypeName("internationalCertification")
public class InternationalCertification extends DocumentType {
    @Column(name = "box_number")
    private Long boxNumber;
    @Column(name = "process_number")
    private String processNumber;
    private String company;
}