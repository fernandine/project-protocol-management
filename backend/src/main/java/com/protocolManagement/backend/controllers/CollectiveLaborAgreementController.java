package com.protocolManagement.backend.controllers;

import com.protocolManagement.backend.services.CollectiveLaborAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/collective-labors")
public class CollectiveLaborAgreementController {

    @Autowired
    private CollectiveLaborAgreementService service;
}
