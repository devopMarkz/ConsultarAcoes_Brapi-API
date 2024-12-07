package com.marcos.build_and_run.controllers.handlers;

import com.marcos.build_and_run.dto.ErrorFieldsResponseDto;
import com.marcos.build_and_run.dto.ErrorResponseDto;
import com.marcos.build_and_run.services.exceptions.DbViolateIntegrityException;
import com.marcos.build_and_run.services.exceptions.UsuarioInexistenteException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(UsuarioInexistenteException.class)
    public ResponseEntity<ErrorResponseDto> usuarioInexistente(UsuarioInexistenteException e, HttpServletRequest servlet){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(Instant.now(), status.value(), e.getMessage(), servlet.getRequestURI());
        return ResponseEntity.status(status).body(errorResponseDto);
    }

    @ExceptionHandler(DbViolateIntegrityException.class)
    public ResponseEntity<ErrorResponseDto> DbViolateIntegrity(DbViolateIntegrityException e, HttpServletRequest servlet){
        HttpStatus status = HttpStatus.CONFLICT;
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(Instant.now(), status.value(), e.getMessage(), servlet.getRequestURI());
        return ResponseEntity.status(status).body(errorResponseDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorFieldsResponseDto> methodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorFieldsResponseDto errorResponseDto = new ErrorFieldsResponseDto(Instant.now(), status.value(), "Erro de entrada de dados.");
        for (FieldError error : e.getFieldErrors()){
            errorResponseDto.getErrors().add(new com.marcos.build_and_run.dto.FieldError(error.getField(), error.getDefaultMessage()));
        }
        return ResponseEntity.status(status).body(errorResponseDto);
    }

}
