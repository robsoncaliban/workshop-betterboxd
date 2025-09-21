package com.atoserobson.betterboxd.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atoserobson.betterboxd.controllers.dto.categoria.CategoriaRequest;
import com.atoserobson.betterboxd.controllers.dto.categoria.CategoriaResponse;
import com.atoserobson.betterboxd.services.CategoriaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categorias")
public class CategoriaController {

        private final CategoriaService categoriaService;

        @PostMapping
        public ResponseEntity<CategoriaResponse> create(@RequestBody @Valid CategoriaRequest request) {
                var categoria = categoriaService.create(request);
                return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
        }

}
