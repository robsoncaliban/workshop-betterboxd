package com.atoserobson.betterboxd.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atoserobson.betterboxd.controllers.dto.filme.FilmeRequest;
import com.atoserobson.betterboxd.controllers.dto.filme.FilmeResponse;
import com.atoserobson.betterboxd.services.FilmeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/filmes")
public class FilmeController {

        private final FilmeService filmeService;

        @PostMapping
        public ResponseEntity<FilmeResponse> create(@RequestBody @Valid FilmeRequest request) {
                var filme = filmeService.create(request);
                return ResponseEntity.status(HttpStatus.CREATED).body(filme);
        }

}
