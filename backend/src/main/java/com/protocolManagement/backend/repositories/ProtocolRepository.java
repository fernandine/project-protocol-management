package com.protocolManagement.backend.repositories;

import com.protocolManagement.backend.entities.Protocol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProtocolRepository extends JpaRepository<Protocol, Long> {

    Protocol findByProtocolNumber(String protocolNumber);
}
