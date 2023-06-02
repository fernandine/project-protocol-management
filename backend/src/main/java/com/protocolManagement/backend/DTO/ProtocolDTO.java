package com.protocolManagement.backend.DTO;

import com.protocolManagement.backend.entities.Accounting;
import com.protocolManagement.backend.entities.DocumentType;
import com.protocolManagement.backend.entities.enums.EntityType;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProtocolDTO implements Serializable {

    private Long id;
    private EntityType entity;
    private String management;
    private String operatingUnit;
    private String protocolNumber;
    private DocumentType document;
    private UserDTO user;

}
