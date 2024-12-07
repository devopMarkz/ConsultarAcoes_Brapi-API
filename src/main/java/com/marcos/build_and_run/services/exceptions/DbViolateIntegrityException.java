package com.marcos.build_and_run.services.exceptions;

public class DbViolateIntegrityException extends RuntimeException {
    public DbViolateIntegrityException(String message) {
        super(message);
    }
}
