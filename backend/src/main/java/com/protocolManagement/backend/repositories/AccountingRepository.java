package com.protocolManagement.backend.repositories;

import com.protocolManagement.backend.entities.Accounting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountingRepository extends JpaRepository<Accounting, Long> {
}
