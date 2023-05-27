package com.protocolManagement.backend.controllers;

import com.protocolManagement.backend.services.InternationalCertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/international-certifications")
public class InternationalCertificationController {

    @Autowired
    private InternationalCertificationService service;
}
