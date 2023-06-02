package com.protocolManagement.backend.entities;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.protocolManagement.backend.entities.enums.StatusFunctionalFolder;
import javax.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_functional_folder")
@JsonTypeName("functionalFolder")
public class FunctionalFolder extends DocumentType {

    private StatusFunctionalFolder status;
    @Column(name = "registry_employee")
    private String registryEmployee;
    @Column(name = "box_number")
    private Long boxNumber;
    @Column (columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant shutdown;

    public FunctionalFolder(){}

    public FunctionalFolder(StatusFunctionalFolder status, String registryEmployee, Long boxNumber, Instant shutdown) {

        this.status = status;
        this.registryEmployee = registryEmployee;
        this.boxNumber = boxNumber;
        this.shutdown = shutdown;
    }

    public StatusFunctionalFolder getStatus() {
        return status;
    }

    public void setStatus(StatusFunctionalFolder status) {
        this.status = status;
    }

    public String getRegistryEmployee() {
        return registryEmployee;
    }

    public void setRegistryEmployee(String registryEmployee) {
        this.registryEmployee = registryEmployee;
    }

    public Long getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(Long boxNumber) {
        this.boxNumber = boxNumber;
    }

    public Instant getShutdown() {
        return shutdown;
    }

    public void setShutdown(Instant shutdown) {
        this.shutdown = shutdown;
    }

}