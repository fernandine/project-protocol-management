package com.protocolManagement.backend.services;

import com.protocolManagement.backend.repositories.CollectiveLaborAgreementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectiveLaborAgreementService {

    @Autowired
    private CollectiveLaborAgreementRepository repository;
}
