package com.atoserobson.betterboxd.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atoserobson.betterboxd.controllers.docs.CategoriaController;
import com.atoserobson.betterboxd.controllers.dto.categoria.CategoriaRequest;
import com.atoserobson.betterboxd.controllers.dto.categoria.CategoriaResponse;
import com.atoserobson.betterboxd.controllers.dto.filme.FilmeResponse;
import com.atoserobson.betterboxd.services.CategoriaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categorias")
public class CategoriaControllerImpl implements CategoriaController {

        private final CategoriaService categoriaService;

        @PostMapping
        public ResponseEntity<CategoriaResponse> criar(@RequestBody @Valid CategoriaRequest request) {
                var categoria = categoriaService.criar(request);
                return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
        }

        @GetMapping
        public ResponseEntity<List<CategoriaResponse>> buscarTodos() {
                var categorias = categoriaService.buscarTodos();
                return ResponseEntity.ok(categorias);
        }

        @GetMapping("/{id}/filmes")
        public ResponseEntity<List<FilmeResponse>> buscarFilmesDeCategoria(@PathVariable Long id) {
                var categorias = categoriaService.buscarFilmesDeCategoria(id);
                return ResponseEntity.ok(categorias);
        }

        @PutMapping("/{id}")
        public ResponseEntity<CategoriaResponse> atualizar(Long id, CategoriaRequest request) {
                var categoria = categoriaService.atualizar(id, request);
                return ResponseEntity.ok(categoria);
        }

}
