package com.protocolManagement.backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDTO implements Serializable {

    private Long id;
    private String corporateName;
    private String cnpj;
    private String mobileNumber;
    private String email;
}
