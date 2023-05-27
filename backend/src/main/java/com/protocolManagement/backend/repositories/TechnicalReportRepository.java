package com.protocolManagement.backend.repositories;

import com.protocolManagement.backend.entities.TechnicalReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalReportRepository extends JpaRepository<TechnicalReport, Long> {
}
