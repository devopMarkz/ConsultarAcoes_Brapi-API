package com.marcos.build_and_run.repositories;

import com.marcos.build_and_run.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT p FROM Usuario p JOIN FETCH p.contas")
    public Usuario findUsuarioByIdWithConta(Long id);

}
