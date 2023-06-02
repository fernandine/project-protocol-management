package com.protocolManagement.backend.entities;

import com.fasterxml.jackson.annotation.JsonTypeName;
import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_international_certification")
@JsonTypeName("internationalCertification")
public class InternationalCertification extends DocumentType {

    @Column(name = "box_number")
    private Long boxNumber;
    @Column(name = "process_number")
    private String processNumber;
    private String company;

    public InternationalCertification(){}

    public InternationalCertification(Long id, String entity, Long boxNumber, String processNumber, String company) {
        this.boxNumber = boxNumber;
        this.processNumber = processNumber;
        this.company = company;
    }

    public Long getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(Long boxNumber) {
        this.boxNumber = boxNumber;
    }

    public String getProcessNumber() {
        return processNumber;
    }

    public void setProcessNumber(String processNumber) {
        this.processNumber = processNumber;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

}
