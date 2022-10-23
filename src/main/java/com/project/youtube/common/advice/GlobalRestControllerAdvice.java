package com.project.youtube.common.advice;

import com.project.youtube.common.exception.ApiException;
import com.project.youtube.common.exception.BadRequestException;
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

@RestControllerAdvice
public class GlobalRestControllerAdvice {

    @ExceptionHandler(NoSuchElementException.class)
     ResponseEntity<ApiException> handleResourceNotFoundException(NoSuchElementException exception){
        return new ResponseEntity<>(ApiException.builder()
                .message("Resource not found")
                .status(HttpStatus.NOT_FOUND)
                .build(),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
     ResponseEntity<ApiException> handleValidationError(MethodArgumentNotValidException ex){
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
    ResponseEntity<ApiException> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex){
        return new ResponseEntity<>(ApiException.builder()
                .message("Invalid arguments")
                .status(HttpStatus.BAD_REQUEST)
                .build(),
                HttpStatus.BAD_REQUEST
        );
    }

//    @ExceptionHandler(DataIntegrityViolationException.class)
//    ResponseEntity<ApiException> handleDataIntegrityViolationException(DataIntegrityViolationException ex){
//        return new ResponseEntity<>(ApiException.builder()
//                .message(ex.getMessage())
//                .status(HttpStatus.BAD_REQUEST)
//                .build(),
//                HttpStatus.BAD_REQUEST
//        );
//    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    ResponseEntity<ApiException> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex){
        return new ResponseEntity<>(ApiException.builder()
                .message("Please provide valid JSON body")
                .status(HttpStatus.BAD_REQUEST)
                .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(BadRequestException.class)
    ResponseEntity<ApiException> handleBadRequestException(BadRequestException ex){
        return new ResponseEntity<>(ApiException.builder()
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .build(),
                HttpStatus.BAD_REQUEST
        );
    }

}
