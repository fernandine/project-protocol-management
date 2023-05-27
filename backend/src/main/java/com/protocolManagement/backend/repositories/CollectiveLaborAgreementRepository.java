package com.protocolManagement.backend.repositories;

import com.protocolManagement.backend.entities.CollectiveLaborAgreement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectiveLaborAgreementRepository extends JpaRepository<CollectiveLaborAgreement, Long> {
}
