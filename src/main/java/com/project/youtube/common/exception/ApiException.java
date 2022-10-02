package com.project.youtube.common.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
public final class ApiException {
    private final String message;
    private final HttpStatus status;
    private final LocalDateTime timeStamp = LocalDateTime.now();
    private final Map<String, String> fields;
}
