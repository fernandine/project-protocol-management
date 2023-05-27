package com.protocolManagement.backend.repositories;

import com.protocolManagement.backend.entities.Contracts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractsRepository extends JpaRepository<Contracts, Long> {
}
