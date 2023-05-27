package com.protocolManagement.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_selection_process")
public class SelectionProcess implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String employee;
    private Long registry;
    private Long vacancyNumber;
    private String vacancyName;
    private Long boxNumber;

    public SelectionProcess(){}

    public SelectionProcess(Long id, String employee, Long registry, Long vacancyNumber, String vacancyName, Long boxNumber) {
        this.id = id;
        this.employee = employee;
        this.registry = registry;
        this.vacancyNumber = vacancyNumber;
        this.vacancyName = vacancyName;
        this.boxNumber = boxNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SelectionProcess that)) return false;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
