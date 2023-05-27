package com.protocolManagement.backend.services;

import com.protocolManagement.backend.DTO.EmailDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MockEmailService implements EmailService {

    private static Logger LOG = LoggerFactory.getLogger(MockEmailService.class);
    public void sendEmail(EmailDTO dto) {
            LOG.info("Sending email to: " + dto.getTo());
            LOG.info("Email sent!");
        }
}
