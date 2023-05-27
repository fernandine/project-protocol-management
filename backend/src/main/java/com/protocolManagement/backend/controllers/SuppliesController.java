package com.protocolManagement.backend.controllers;

import com.protocolManagement.backend.services.SuppliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/supplies")
public class SuppliesController {

    @Autowired
    private SuppliesService service;
}
