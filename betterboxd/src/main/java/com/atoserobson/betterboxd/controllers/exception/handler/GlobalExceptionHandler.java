package com.atoserobson.betterboxd.controllers.exception.handler;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(DataIntegrityViolationException.class)
        public ResponseEntity<ExceptionResponse> dataIntegrityViolationException(
                        DataIntegrityViolationException exception,
                        HttpServletRequest request) {
                var status = HttpStatus.CONFLICT;
                var messageException = new ExceptionResponse(request, status, exception.getMessage());
                var contentType = MediaType.APPLICATION_JSON;

                return ResponseEntity
                                .status(status)
                                .contentType(contentType)
                                .body(messageException);
        }

        @ExceptionHandler(EntityNotFoundException.class)
        public ResponseEntity<ExceptionResponse> entityNotFoundException(EntityNotFoundException exception,
                        HttpServletRequest request) {
                var status = HttpStatus.NOT_FOUND;
                var messageException = new ExceptionResponse(request, status, exception.getMessage());
                var contentType = MediaType.APPLICATION_JSON;

                return ResponseEntity
                                .status(status)
                                .contentType(contentType)
                                .body(messageException);
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ExceptionResponse> methodArgumentNotValidException(
                        MethodArgumentNotValidException exception,
                        HttpServletRequest request, BindingResult result) {
                var status = HttpStatus.UNPROCESSABLE_ENTITY;
                var messageException = new ExceptionResponse(request, status, "Invalid input(s)", result);
                var contentType = MediaType.APPLICATION_JSON;

                return ResponseEntity
                                .status(status)
                                .contentType(contentType)
                                .body(messageException);
        }

}
