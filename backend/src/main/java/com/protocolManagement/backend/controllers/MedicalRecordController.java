package com.protocolManagement.backend.controllers;

import com.protocolManagement.backend.services.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/medical-records")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService service;
}
