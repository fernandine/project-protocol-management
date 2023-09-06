package com.protocolManagement.backend.entities;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.protocolManagement.backend.entities.enums.EntityType;
import com.protocolManagement.backend.entities.enums.StatusFunctionalFolder;
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
@Table(name = "tb_functional_folder")
@JsonTypeName("functionalFolder")
public class FunctionalFolder extends DocumentType {

    private StatusFunctionalFolder status;
    @Column(name = "registry_employee")
    private String registryEmployee;
    @Column(name = "box_number")
    private Long boxNumber;
    @Column (columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant shutdown; //ano do desligamento

}