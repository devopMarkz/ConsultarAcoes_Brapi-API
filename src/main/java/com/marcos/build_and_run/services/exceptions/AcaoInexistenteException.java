package com.marcos.build_and_run.services.exceptions;

public class AcaoInexistenteException extends RuntimeException {
    public AcaoInexistenteException(String message) {
        super(message);
    }
}
