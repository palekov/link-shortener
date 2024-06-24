package ru.palekov.linkshortener.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.palekov.linkshortener.dto.common.CommonResponse;
import ru.palekov.linkshortener.dto.common.ValidationError;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class LinkShortenerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResponse<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        List<ValidationError> validationErrors = fieldErrors.stream()
                .map(fieldError -> ValidationError.builder()
                        .field(fieldError.getField())
                        .message(fieldError.getDefaultMessage())
                        .build())
                .toList();

        log.error("Request validation error: {}", validationErrors, e);

        return CommonResponse.builder()
                .errorMessage("Validation error")
                .validationErrors(validationErrors)
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public CommonResponse<?> handlerException(Exception e) {
        log.error("Unexpected error: {}", e.getMessage(), e);
        return CommonResponse.builder()
                .errorMessage("Unexpected error: " + e.getMessage())
                .build();
    }
}
