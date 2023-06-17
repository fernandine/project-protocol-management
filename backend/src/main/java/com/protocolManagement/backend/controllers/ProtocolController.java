package com.protocolManagement.backend.controllers;

import com.protocolManagement.backend.DTO.ProtocolDTO;
import com.protocolManagement.backend.services.ProtocolService;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.sql.Connection;
import java.util.List;

@Validated
@RestController
@RequestMapping(value = "/protocols")
@CrossOrigin(origins = "http://localhost:4200")
public class ProtocolController {

    @Autowired
    private ProtocolService service;

    @Autowired
    private Connection connection;

//    @GetMapping("/conn")
//    public String myConn(Model model) {
//        model.addAttribute("conn", connection != null ? "Conexão ok!" : "Ops...sem conexão");
//        return "index";
//    }

    @GetMapping
    public ResponseEntity<Page<ProtocolDTO>> findAll(Pageable pageable) {
        Page<ProtocolDTO> page = service.findAll(pageable);
        return ResponseEntity.ok().body(page);
    }

    @GetMapping("/searchBy/{protocolNumber}")
    public ResponseEntity<ProtocolDTO> findByProtocol(@PathVariable("protocolNumber") String protocolNumber) {
        ProtocolDTO dto = service.findByProtocol(protocolNumber);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProtocolDTO> findById(@PathVariable @Positive @NotNull Long id) {
        ProtocolDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<ProtocolDTO> insert(@RequestBody @Valid ProtocolDTO dto) {
        ProtocolDTO newDto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newDto.getId()).toUri();
        return ResponseEntity.created(uri).body(newDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProtocolDTO> update(
            @PathVariable @Positive @NotNull Long id,
            @RequestBody @Valid ProtocolDTO dto
    ) {
        ProtocolDTO newDto = service.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Positive @NotNull Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
