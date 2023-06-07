package com.protocolManagement.backend.services;

import com.protocolManagement.backend.DTO.ProtocolDTO;
import com.protocolManagement.backend.entities.DocumentType;
import com.protocolManagement.backend.entities.Protocol;
import com.protocolManagement.backend.entities.User;
import com.protocolManagement.backend.repositories.ProtocolRepository;
import com.protocolManagement.backend.services.exceptions.DatabaseException;
import com.protocolManagement.backend.services.exceptions.ResourceNotFoundException;
import javax.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProtocolService {

    @Autowired
    private ProtocolRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    public List<ProtocolDTO> findAll() {
        List<Protocol> list = repository.findAll();
        return list.stream()
                .map(order -> modelMapper.map(order, ProtocolDTO.class))
                .collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public ProtocolDTO getAuthUser() {
        User user = authService.authenticated();
        return modelMapper.map(user, ProtocolDTO.class);
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
        copyDtoToEntity(dto, entity);
        User user = authService.authenticated();
        user.setId(userService.getAuthUser().getId());
        entity.setUser(user);
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

    public String createProtocol(DocumentType documentType) {
        Protocol protocol = new Protocol();
        protocol.setInstitution(documentType.getEntity());
        protocol.setId(documentType.getId());
        protocol.setProtocolNumber(generateProtocolNumber(protocol));

        // Aqui você pode adicionar qualquer lógica adicional, como persistir o protocolo no banco de dados ou realizar outras operações relacionadas ao protocolo

        return "Protocolo criado com sucesso! Código: " + protocol.getProtocolNumber();
    }

    private String generateProtocolNumber(Protocol protocol) {
        return "DOC" + protocol.getId() + "-" + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

    private void copyDtoToEntity(ProtocolDTO dto, Protocol entity) {

        entity.setInstitution(dto.getInstitution());
        entity.setOperatingUnit(dto.getOperatingUnit());
        entity.setManagement(dto.getManagement());
        entity.setDocuments(dto.getDocuments().stream().toList());

        entity.setProtocolNumber(generateProtocolNumber(entity));
    }
}

