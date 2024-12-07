package com.marcos.build_and_run.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class UsuarioDto {

    private Long id;
    private String username;
    @Email(message = "E-mail inválido.")
    private String email;
    @Size(min = 8, message = "Sua senha deve conter no mínimo 8 caracteres.")
    private String password;

    public UsuarioDto(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
