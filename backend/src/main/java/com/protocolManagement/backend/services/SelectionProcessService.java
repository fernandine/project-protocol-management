package com.protocolManagement.backend.services;

import com.protocolManagement.backend.repositories.SelectionProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelectionProcessService {

    @Autowired
    private SelectionProcessRepository repository;
}
