package com.protocolManagement.backend.controllers;

import com.protocolManagement.backend.services.FuncionalFolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/funcional-folders")
public class FuncionalFolderController {

    @Autowired
    private FuncionalFolderService service;
}
