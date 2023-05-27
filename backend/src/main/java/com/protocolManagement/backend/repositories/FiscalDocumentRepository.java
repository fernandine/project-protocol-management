package com.protocolManagement.backend.repositories;

import com.protocolManagement.backend.entities.FiscalDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiscalDocumentRepository extends JpaRepository<FiscalDocument, Long> {
}
