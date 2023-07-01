package com.protocolManagement.backend.services;

import com.protocolManagement.backend.DTO.*;
import com.protocolManagement.backend.entities.Company;
import com.protocolManagement.backend.repositories.CompanyRepository;
import com.protocolManagement.backend.services.exceptions.DatabaseException;
import com.protocolManagement.backend.services.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public List<CompanyDTO> findAll() {
        List<Company> list = repository.findAll();
        return list.stream()
                .map(company -> modelMapper.map(company, CompanyDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CompanyDTO findById(Long id) {
        Optional<Company> obj = repository.findById(id);
        Company entity = obj.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
        return modelMapper.map(entity, CompanyDTO.class);
    }

    @Transactional
    public CompanyDTO insert(CompanyDTO dto) {
        Company entity = new Company();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return modelMapper.map(entity, CompanyDTO.class);
    }

    @Transactional
    public CompanyDTO update(Long id, CompanyDTO dto) {
        try {
            Company entity = repository.getReferenceById(id);

            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return modelMapper.map(entity, CompanyDTO.class);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Identificador não encontrado " + id);
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Identificador não encontrado " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

    private void copyDtoToEntity(CompanyDTO dto, Company entity) {

        entity.setCnpj(dto.getCnpj());
        entity.setEmail(dto.getEmail());
        entity.setCorporateName(dto.getCorporateName());
        entity.setMobileNumber(dto.getMobileNumber());

    }
}
