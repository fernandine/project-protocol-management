package com.protocolManagement.backend.services;

import com.protocolManagement.backend.repositories.ProtocolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProtocolService {

    @Autowired
    private ProtocolRepository repository;


}
