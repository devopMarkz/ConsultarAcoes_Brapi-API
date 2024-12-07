package com.marcos.build_and_run.repositories;

import com.marcos.build_and_run.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u JOIN FETCH u.contas WHERE u.id = :id")
    public Usuario findUsuarioByIdWithConta(@Param("id") Long id);

}
