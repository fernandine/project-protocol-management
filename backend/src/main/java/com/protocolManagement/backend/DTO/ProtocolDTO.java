package com.protocolManagement.backend.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.protocolManagement.backend.entities.DocumentType;
import com.protocolManagement.backend.entities.Protocol;
import com.protocolManagement.backend.entities.enums.EntityType;
import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProtocolDTO implements Serializable {

    @JsonProperty("_id")
    private Long id;
    private EntityType institution;
    private String management;
    private String operatingUnit;
    private String protocolNumber;
    private List<DocumentType> documents;
    private UserDTO user;
    private Boolean received;
    @Column (columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant receivedDate;

}