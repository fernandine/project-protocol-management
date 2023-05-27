package com.protocolManagement.backend.controllers;

import com.protocolManagement.backend.services.FiscalDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/fiscal-documents")
public class FiscalDocumentController {

    @Autowired
    private FiscalDocumentService service;
}
