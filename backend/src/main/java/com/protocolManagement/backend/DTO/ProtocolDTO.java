package com.protocolManagement.backend.DTO;

import java.io.Serializable;

public class ProtocolDTO implements Serializable {

    private Long id;
    private String entity;
    private String management;
    private String operatingUnit;

    public ProtocolDTO(){}

    public ProtocolDTO(Long id, String entity, String management, String operatingUnit) {
        this.id = id;
        this.entity = entity;
        this.management = management;
        this.operatingUnit = operatingUnit;
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

    public String getManagement() {
        return management;
    }

    public void setManagement(String management) {
        this.management = management;
    }

    public String getOperatingUnit() {
        return operatingUnit;
    }

    public void setOperatingUnit(String operatingUnit) {
        this.operatingUnit = operatingUnit;
    }
}
