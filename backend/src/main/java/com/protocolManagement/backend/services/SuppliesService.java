package com.protocolManagement.backend.services;

import com.protocolManagement.backend.repositories.SuppliesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuppliesService {

    @Autowired
    private SuppliesRepository repository;
}
