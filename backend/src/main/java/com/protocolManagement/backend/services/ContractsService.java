package com.protocolManagement.backend.services;

import com.protocolManagement.backend.repositories.ContractsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractsService {

    @Autowired
    private ContractsRepository repository;
}
