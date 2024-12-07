package com.marcos.build_and_run.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ErrorFieldsResponseDto {

    private Instant timestamp;
    private Integer status;
    private String message;
    private List<FieldError> errors = new ArrayList<>();

    public ErrorFieldsResponseDto(Instant timestamp, Integer status, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<FieldError> getErrors() {
        return errors;
    }
}
