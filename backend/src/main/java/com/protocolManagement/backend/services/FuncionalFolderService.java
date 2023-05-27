package com.protocolManagement.backend.services;

import com.protocolManagement.backend.repositories.FuncionalFolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionalFolderService {

    @Autowired
    private FuncionalFolderRepository repository;
}
