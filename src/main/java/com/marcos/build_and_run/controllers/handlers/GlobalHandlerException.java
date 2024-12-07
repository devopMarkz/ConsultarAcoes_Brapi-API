package com.marcos.build_and_run.controllers.handlers;

import com.marcos.build_and_run.services.UsuarioInexistenteException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(UsuarioInexistenteException.class)
    public ResponseEntity<String> usuarioInexistente(UsuarioInexistenteException e, HttpServletRequest servlet){
        HttpStatus status = HttpStatus.NOT_FOUND;
        String error = e.getMessage() + " / " + servlet.getRequestURI();
        return ResponseEntity.status(status).body(error);
    }

}
