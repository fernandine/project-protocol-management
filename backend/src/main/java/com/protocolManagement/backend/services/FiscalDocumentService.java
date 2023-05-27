package com.protocolManagement.backend.services;

import com.protocolManagement.backend.repositories.FiscalDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FiscalDocumentService {

    @Autowired
    private FiscalDocumentRepository repository;
}
