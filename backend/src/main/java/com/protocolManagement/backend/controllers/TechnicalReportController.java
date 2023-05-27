package com.protocolManagement.backend.controllers;

import com.protocolManagement.backend.services.TechnicalReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/technical-reports")
public class TechnicalReportController {

    @Autowired
    private TechnicalReportService service;
}
