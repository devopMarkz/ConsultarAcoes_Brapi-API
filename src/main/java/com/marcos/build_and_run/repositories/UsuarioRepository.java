package com.marcos.build_and_run.repositories;

import com.marcos.build_and_run.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
