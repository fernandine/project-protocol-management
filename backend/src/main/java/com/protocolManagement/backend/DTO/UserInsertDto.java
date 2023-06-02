package com.protocolManagement.backend.DTO;


import com.protocolManagement.backend.services.Validation.UserInsertValid;

@UserInsertValid
public class UserInsertDto extends UserDTO {

    private String password;

    UserInsertDto() {
        super();
    }

    public String getPassword() {
        return password;
    }
}
