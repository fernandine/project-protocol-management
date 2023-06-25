package com.protocolManagement.backend.repositories;

import com.protocolManagement.backend.entities.Protocol;
import com.protocolManagement.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProtocolRepository extends JpaRepository<Protocol, Long> {

    Protocol findByProtocolNumber(String protocolNumber);

    //BUSCA OS RECEBIDOS
    @Query("SELECT obj FROM Protocol obj WHERE "
            + "(:notReceived = false OR obj.received = false) ")
    List<Protocol> find(boolean notReceived);
}
