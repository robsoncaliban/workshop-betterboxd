package com.atoserobson.betterboxd.controllers.exception.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Getter
public class ExceptionResponse {

        private String path;
        private String method;
        private int status;
        private String statusText;
        private String message;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private Map<String, String> errors;

        public ExceptionResponse(HttpServletRequest request, HttpStatus status, String message) {
                this.path = request.getRequestURI();
                this.method = request.getMethod();
                this.status = status.value();
                this.statusText = status.getReasonPhrase();
                this.message = message;
        }

        public ExceptionResponse(HttpServletRequest request, HttpStatus status, String message, BindingResult result) {
                this.path = request.getRequestURI();
                this.method = request.getMethod();
                this.status = status.value();
                this.statusText = status.getReasonPhrase();
                this.message = message;
                addErrors(result);
        }

        private void addErrors(BindingResult result) {
                this.errors = new HashMap<>();

                result.getFieldErrors().forEach(
                                fieldError -> errors.put(fieldError.getField(), fieldError.getDefaultMessage()));
        }

}
