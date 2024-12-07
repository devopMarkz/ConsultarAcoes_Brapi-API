package com.marcos.build_and_run.dto;

import java.time.Instant;

public record ErrorResponseDto(Instant timestamp, Integer status, String message, String path) {
}
