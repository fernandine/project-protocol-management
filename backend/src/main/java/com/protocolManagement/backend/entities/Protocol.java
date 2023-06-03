package com.protocolManagement.backend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.protocolManagement.backend.entities.enums.EntityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_protocol")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Protocol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("_id")
    private Long id;
    private String protocolNumber;

    @Enumerated(EnumType.STRING)
    private EntityType core;
    private String management;
    private String operatingUnit;

    @OneToOne(mappedBy = "protocol", cascade = CascadeType.ALL)
    private DocumentType document;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
