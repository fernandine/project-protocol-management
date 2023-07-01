package com.protocolManagement.backend.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_company")
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name="corporate_name")
    private String corporateName;
    @NotNull
    private String cnpj;
    @Column(name="mobile_number")
    private String mobileNumber;
    private String email;
}
