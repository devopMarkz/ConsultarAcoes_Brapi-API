package com.marcos.build_and_run.repositories;

import com.marcos.build_and_run.entities.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}
