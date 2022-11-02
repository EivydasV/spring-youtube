package com.project.youtube.common.advice;

import com.project.youtube.common.exception.ApiException;
import com.project.youtube.common.exception.BadRequestException;
import com.project.youtube.common.exception.UniqueConstrainsException;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

@RestControllerAdvice
public class GlobalRestControllerAdvice {

    @ExceptionHandler(NoSuchElementException.class)
     ResponseEntity<ApiException> handleResourceNotFoundException(){
        return new ResponseEntity<>(ApiException.builder()
                .message("Resource not found")
                .status(HttpStatus.NOT_FOUND)
                .build(),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
     ResponseEntity<ApiException> handleValidationError(@NotNull MethodArgumentNotValidException ex){
        Map<String, String> fields = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            fields.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(ApiException.builder()
                .message("Validation error")
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .fields(fields)
                .build(),
                HttpStatus.UNPROCESSABLE_ENTITY
        );
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    ResponseEntity<ApiException> handleMethodArgumentTypeMismatchException(){
        return new ResponseEntity<>(ApiException.builder()
                .message("Invalid arguments")
                .status(HttpStatus.BAD_REQUEST)
                .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    ResponseEntity<ApiException> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        String substringBetween = StringUtils.substringBetween(Objects.requireNonNull(ex.getRootCause()).getMessage(), "(", ")");
        Map<String, String> fields = new HashMap<>();
        fields.put(substringBetween, substringBetween + " already exists");
        return new ResponseEntity<>(ApiException.builder()
                .message("Conflict error")
                .status(HttpStatus.CONFLICT)
                .fields(fields)
                .build(),
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    ResponseEntity<ApiException> handleHttpMessageNotReadableException(){
        return new ResponseEntity<>(ApiException.builder()
                .message("Please provide valid JSON body")
                .status(HttpStatus.BAD_REQUEST)
                .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(BadRequestException.class)
    ResponseEntity<ApiException> handleBadRequestException(@NotNull BadRequestException ex){
        return new ResponseEntity<>(ApiException.builder()
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(UniqueConstrainsException.class)
    ResponseEntity<ApiException> handleUniqueConstrainsException(@NotNull UniqueConstrainsException ex){
        final HttpStatus status = HttpStatus.CONFLICT;
        return new ResponseEntity<>(ApiException.builder()
                .message(ex.getMessage())
                .status(status)
                .build(),
                status
        );
    }

//    @ExceptionHandler(Exception.class)
//    ResponseEntity<ApiException> handleException(Exception ex){
//        System.out.println(ex.toString());
//        return new ResponseEntity<>(ApiException.builder()
//                .message("Something went wrong")
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .build(),
//                HttpStatus.INTERNAL_SERVER_ERROR
//        );
//    }
}
