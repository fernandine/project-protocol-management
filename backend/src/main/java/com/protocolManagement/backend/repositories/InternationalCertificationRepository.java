package com.protocolManagement.backend.repositories;

import com.protocolManagement.backend.entities.InternationalCertification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternationalCertificationRepository extends JpaRepository<InternationalCertification, Long> {
}
