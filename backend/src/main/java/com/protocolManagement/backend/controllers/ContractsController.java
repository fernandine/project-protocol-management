package com.protocolManagement.backend.controllers;

import com.protocolManagement.backend.services.ContractsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/contracts")
public class ContractsController {

    @Autowired
    private ContractsService service;
}
