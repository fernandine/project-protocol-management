package com.protocolManagement.backend.controllers;

import com.protocolManagement.backend.DTO.ProtocolDTO;
import com.protocolManagement.backend.entities.DocumentType;
import com.protocolManagement.backend.entities.Protocol;
import com.protocolManagement.backend.services.ProtocolService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value = "/protocols")
public class ProtocolController {

    @Autowired
    private ProtocolService service;

    @GetMapping
    public ResponseEntity<List<ProtocolDTO>> findAll() {
        List<ProtocolDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProtocolDTO> findById(@PathVariable Long id) {
        ProtocolDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping("/generate")
    public String createProtocol(@RequestBody DocumentType documentType) {
        Protocol protocol = new Protocol();
        protocol.setInstitution(documentType.getEntity());
        protocol.setId(documentType.getId());

        protocol.setProtocolNumber(
                "DOC" + protocol.getId() + "-" +
                        LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("yyyyMMdd")) +
                        new Random().nextInt(900) + 100
        );

        return "Protocolo criado com sucesso. Número do protocolo: " + protocol.getProtocolNumber();
    }
    @PostMapping
    public ResponseEntity<ProtocolDTO> insert(@RequestBody @Valid ProtocolDTO dto) {
        ProtocolDTO newDto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newDto.getId()).toUri();
        return ResponseEntity.created(uri).body(newDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProtocolDTO> update(@PathVariable Long id, @RequestBody @Valid ProtocolDTO dto) {
        ProtocolDTO newDto = service.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
