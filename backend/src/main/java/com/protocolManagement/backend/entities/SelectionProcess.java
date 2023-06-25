package com.protocolManagement.backend.entities;

import com.fasterxml.jackson.annotation.JsonTypeName;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "tb_selection_process")
@JsonTypeName("selectionProcess")
public class SelectionProcess extends DocumentType {

    @NotNull
    private String employee;
    private Long registry;
    @Column(name = "vacancy_number")
    private Long vacancyNumber;
    @Column(name = "vacancy_name")
    private String vacancyName;
    @Column(name = "box_number")
    private Long boxNumber;

    public SelectionProcess(){}

    public SelectionProcess( String employee, Long registry, Long vacancyNumber, String vacancyName, Long boxNumber) {
        this.employee = employee;
        this.registry = registry;
        this.vacancyNumber = vacancyNumber;
        this.vacancyName = vacancyName;
        this.boxNumber = boxNumber;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public Long getRegistry() {
        return registry;
    }

    public void setRegistry(Long registry) {
        this.registry = registry;
    }

    public Long getVacancyNumber() {
        return vacancyNumber;
    }

    public void setVacancyNumber(Long vacancyNumber) {
        this.vacancyNumber = vacancyNumber;
    }

    public String getVacancyName() {
        return vacancyName;
    }

    public void setVacancyName(String vacancyName) {
        this.vacancyName = vacancyName;
    }

    public Long getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(Long boxNumber) {
        this.boxNumber = boxNumber;
    }

}