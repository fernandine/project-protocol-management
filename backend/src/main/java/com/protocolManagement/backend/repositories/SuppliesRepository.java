package com.protocolManagement.backend.repositories;

import com.protocolManagement.backend.entities.Supplies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuppliesRepository extends JpaRepository<Supplies, Long> {
}
