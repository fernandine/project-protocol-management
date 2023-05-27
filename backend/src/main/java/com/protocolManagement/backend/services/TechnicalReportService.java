package com.protocolManagement.backend.services;

import com.protocolManagement.backend.repositories.TechnicalReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechnicalReportService {

    @Autowired
    private TechnicalReportRepository repository;
}
