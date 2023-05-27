package com.protocolManagement.backend.repositories;

import com.protocolManagement.backend.entities.SelectionProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SelectionProcessRepository extends JpaRepository<SelectionProcess, Long> {
}
