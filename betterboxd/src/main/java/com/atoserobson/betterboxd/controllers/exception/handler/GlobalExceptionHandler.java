package com.atoserobson.betterboxd.controllers.exception.handler;

import com.atoserobson.betterboxd.controllers.exception.DuplicidadeDadosException;
import com.atoserobson.betterboxd.controllers.exception.ViolacaoIntegridadeDadosException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.atoserobson.betterboxd.controllers.exception.EntidadeNaoEncontradaException;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(ViolacaoIntegridadeDadosException.class)
        public ResponseEntity<ExceptionResponse> violacaoIntegridadeDadosException(
                        ViolacaoIntegridadeDadosException exception,
                        HttpServletRequest request) {
                var status = HttpStatus.CONFLICT;
                var messageException = new ExceptionResponse(request, status, exception.getMessage());
                var contentType = MediaType.APPLICATION_JSON;

                return ResponseEntity
                                .status(status)
                                .contentType(contentType)
                                .body(messageException);
        }

        @ExceptionHandler(EntidadeNaoEncontradaException.class)
        public ResponseEntity<ExceptionResponse> entidadeNaoEncontradaException(
                        EntidadeNaoEncontradaException exception,
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
                var status = HttpStatus.BAD_REQUEST;
                var messageException = new ExceptionResponse(request, status, "Campos inválidos", result);
                var contentType = MediaType.APPLICATION_JSON;

                return ResponseEntity
                                .status(status)
                                .contentType(contentType)
                                .body(messageException);
        }

}
