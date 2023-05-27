package com.protocolManagement.backend.services;

import com.protocolManagement.backend.repositories.FinancialReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinancialReportService {

    @Autowired
    private FinancialReportRepository repository;
}
