package com.protocolManagement.backend.DTO;

import com.protocolManagement.backend.entities.enums.StatusFuncionalFolder;

import java.io.Serializable;
import java.time.Instant;

public class FuncionalFolderDTO implements Serializable {

    private Long id;
    private String entity;
    private StatusFuncionalFolder status;
    private String registryEmployee;
    private Long boxNumber;
    private Instant shutdown;

    public FuncionalFolderDTO(){}

    public FuncionalFolderDTO(Long id, String entity, StatusFuncionalFolder status, String registryEmployee, Long boxNumber, Instant shutdown) {
        this.id = id;
        this.entity = entity;
        this.status = status;
        this.registryEmployee = registryEmployee;
        this.boxNumber = boxNumber;
        this.shutdown = shutdown;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public StatusFuncionalFolder getStatus() {
        return status;
    }

    public void setStatus(StatusFuncionalFolder status) {
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
