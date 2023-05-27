package com.protocolManagement.backend.services;


import com.protocolManagement.backend.DTO.EmailDTO;

public interface EmailService {

    void sendEmail(EmailDTO dto);
}
