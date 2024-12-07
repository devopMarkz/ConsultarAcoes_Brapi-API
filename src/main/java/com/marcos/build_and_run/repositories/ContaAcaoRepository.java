package com.marcos.build_and_run.repositories;

import com.marcos.build_and_run.entities.ContaAcao;
import com.marcos.build_and_run.entities.ContaAcaoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaAcaoRepository extends JpaRepository<ContaAcao, ContaAcaoId> {
}
