package com.protocolManagement.backend.entities;

import com.data.protocolManagement.entities.enums.StatusFuncionalFolder;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_funcional_folder")
public class FuncionalFolder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String entity;
    private StatusFuncionalFolder status;
    private String registryEmployee;
    private Long boxNumber;
    @Column (columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant shutdown;

    public FuncionalFolder(){}

    public FuncionalFolder(Long id, String entity, StatusFuncionalFolder status, String registryEmployee, Long boxNumber, Instant shutdown) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FuncionalFolder that)) return false;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
