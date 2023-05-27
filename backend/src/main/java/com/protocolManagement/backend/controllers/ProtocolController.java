package com.protocolManagement.backend.controllers;

import com.protocolManagement.backend.services.ProtocolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/protocols")
public class ProtocolController {

    @Autowired
    private ProtocolService service;
}
