package com.protocolManagement.backend.controllers;

import com.protocolManagement.backend.services.AccountingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/accountings")
public class AccountingController {

    @Autowired
    private AccountingService service;


}
