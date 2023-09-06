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
@Table(name = "tb_selection_process")
@JsonTypeName("selectionProcess")
public class SelectionProcess extends DocumentType {

    private String employee;
    private Long registry;
    @Column(name = "vacancy_number")
    private Long vacancyNumber;
    @Column(name = "vacancy_name")
    private String vacancyName;
    @Column(name = "box_number")
    private Long boxNumber;
}