package com.protocolManagement.backend.services;

import com.protocolManagement.backend.repositories.AccountingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountingService {

    @Autowired
    private AccountingRepository repository;
}
