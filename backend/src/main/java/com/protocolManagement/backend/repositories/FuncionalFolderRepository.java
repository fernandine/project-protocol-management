package com.protocolManagement.backend.repositories;

import com.protocolManagement.backend.entities.FuncionalFolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionalFolderRepository extends JpaRepository<FuncionalFolder, Long> {
}
