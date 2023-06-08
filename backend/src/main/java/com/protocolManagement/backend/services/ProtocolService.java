package com.protocolManagement.backend.services;

import com.protocolManagement.backend.DTO.ProtocolDTO;
import com.protocolManagement.backend.DTO.UserDTO;
import com.protocolManagement.backend.entities.DocumentType;
import com.protocolManagement.backend.entities.Protocol;
import com.protocolManagement.backend.entities.User;
import com.protocolManagement.backend.repositories.DocumentTypeRepository;
import com.protocolManagement.backend.repositories.ProtocolRepository;
import com.protocolManagement.backend.services.exceptions.DatabaseException;
import com.protocolManagement.backend.services.exceptions.ResourceNotFoundException;
import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Validated
@Service
public class ProtocolService {

    @Autowired
    private ProtocolRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DocumentTypeRepository documentTypeRepository;
    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    public Page<ProtocolDTO> findAll(Pageable pageable) {
        Page<Protocol> page = repository.findAll(pageable);
        return page
                .map(protocol -> modelMapper.map(protocol, ProtocolDTO.class));
    }

    @Transactional(readOnly = true)
    public ProtocolDTO getAuthUser() {
        User user = authService.authenticated();
        return modelMapper.map(user, ProtocolDTO.class);
    }

    @Transactional(readOnly = true)
    public ProtocolDTO findByProtocol(String protocolNumber) {
        Protocol protocol = repository.findByProtocolNumber(protocolNumber);
        if (protocol == null) {
            throw new ResourceNotFoundException("Protocol not found");
        }
        return modelMapper.map(protocol, ProtocolDTO.class);
    }

    @Transactional(readOnly = true)
    public ProtocolDTO findById(Long id) {
        Optional<Protocol> obj = repository.findById(id);
        Protocol entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return modelMapper.map(entity, ProtocolDTO.class);
    }

    @Transactional
    public ProtocolDTO insert(ProtocolDTO dto) {
        Protocol entity = new Protocol();

        User user = authService.authenticated();
        user.setId(userService.getAuthUser().getId());
        entity.setUser(user);

        copyDtoToEntity(dto, entity);

        entity = repository.save(entity);
        return modelMapper.map(entity, ProtocolDTO.class);
    }

    @Transactional
    public ProtocolDTO update(Long id, ProtocolDTO dto) {
        try {
            Protocol entity = repository.getReferenceById(id);

            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return modelMapper.map(entity, ProtocolDTO.class);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

    public String createProtocol(DocumentType documentType, User user) {
        Protocol protocol = new Protocol();
        protocol.setInstitution(documentType.getEntity());
        protocol.setId(documentType.getId());
        protocol.setProtocolNumber(generateProtocolNumber(user));
        return "Protocolo criado com sucesso! Código: " + protocol.getProtocolNumber();
    }

    private String generateProtocolNumber(User user ) {
        return "DOC" + user.getId() + "-" +
                        LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("yyyyMMdd")) +
                        new Random().nextInt(900) + 100;
    }

    private void copyDtoToEntity(ProtocolDTO dto, Protocol entity) {

        entity.setInstitution(dto.getInstitution());
        entity.setOperatingUnit(dto.getOperatingUnit());
        entity.setManagement(dto.getManagement());
        entity.setProtocolNumber(generateProtocolNumber(entity.getUser()));

        List<DocumentType> documents = new ArrayList<>();
        for (DocumentType document : dto.getDocuments()) {
            document.setProtocol(entity);
            documents.add(document);
        }
        entity.setDocuments(documents);
        repository.save(entity);

        for (DocumentType document : documents) {
            documentTypeRepository.save(document);
        }
    }
}

