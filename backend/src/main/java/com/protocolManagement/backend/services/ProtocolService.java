package com.protocolManagement.backend.services;

import com.protocolManagement.backend.DTO.ProtocolDTO;
import com.protocolManagement.backend.entities.DocumentType;
import com.protocolManagement.backend.entities.Protocol;
import com.protocolManagement.backend.entities.User;
import com.protocolManagement.backend.repositories.DocumentTypeRepository;
import com.protocolManagement.backend.repositories.ProtocolRepository;
import com.protocolManagement.backend.services.exceptions.DatabaseException;
import com.protocolManagement.backend.services.exceptions.ResourceNotFoundException;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

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
        List<ProtocolDTO> protocolDTOs = modelMapper.map(
                page.getContent(),
                new TypeToken<List<ProtocolDTO>>() {}.getType()
        );
        return new PageImpl<>(protocolDTOs, pageable, page.getTotalElements());
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
    public ProtocolDTO findById(@Positive @NotNull Long id) {
        Optional<Protocol> obj = repository.findById(id);
        Protocol entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return modelMapper.map(entity, ProtocolDTO.class);
    }

    @Transactional
    public ProtocolDTO insert(@Valid ProtocolDTO dto) {
        Protocol entity = new Protocol();


        copyDtoToEntity(dto, entity);

        entity = repository.save(entity);
        return modelMapper.map(entity, ProtocolDTO.class);
    }

    @Transactional
    public ProtocolDTO update( Long id, ProtocolDTO dto) {
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

    public void delete(@Positive @NotNull Long id) {
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

    @Transactional(readOnly = true)
    public List<ProtocolDTO> findByReceived(boolean notReceived) {
        List<Protocol> list = repository.find(notReceived);
        return list.stream()
                .map(protocol -> modelMapper.map(protocol, ProtocolDTO.class))
                .collect(Collectors.toList());
    }

//    private String generateProtocolNumber(User user ) {
//        return "DOC" + user.getId() + "-" +
//                LocalDateTime.now().format(
//                        DateTimeFormatter.ofPattern("yyyyMMdd")) +
//                new Random().nextInt(900) + 100;
//    }

    private void copyDtoToEntity(ProtocolDTO dto, Protocol entity) {

        entity.setInstitution(dto.getInstitution());
        entity.setOperatingUnit(dto.getOperatingUnit());
        entity.setManagement(dto.getManagement());
        entity.setProtocolNumber(dto.getProtocolNumber());
        entity.setReceived(dto.getReceived());
        entity.setReceivedDate(dto.getReceivedDate());

        if (dto.getUser() != null) {
            User user = new User();
            user.setId(dto.getUser().getId());
            user.setEmail(dto.getUser().getEmail());
            user.setFirstName(dto.getUser().getFirstName());
            user.setLastName(dto.getUser().getLastName());
            user.setMobileNumber(dto.getUser().getMobileNumber());
            entity.setUser(user);
        }
//        if (entity.getUser() != null) {
//            entity.setProtocolNumber(generateProtocolNumber(user));
//        }

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