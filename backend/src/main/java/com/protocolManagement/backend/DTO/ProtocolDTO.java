package com.protocolManagement.backend.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.protocolManagement.backend.entities.DocumentType;
import com.protocolManagement.backend.entities.enums.EntityType;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProtocolDTO implements Serializable {

    @JsonProperty("_id")
    private Long id;
    private EntityType core;
    private String management;
    private String operatingUnit;
    private String protocolNumber;
    private DocumentType document;
    private UserDTO user;

}
