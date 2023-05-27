package com.protocolManagement.backend.services;

import com.protocolManagement.backend.repositories.InternationalCertificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InternationalCertificationService {

    @Autowired
    private InternationalCertificationRepository repository;
}
