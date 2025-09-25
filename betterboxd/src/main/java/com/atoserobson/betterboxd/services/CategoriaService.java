package com.atoserobson.betterboxd.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atoserobson.betterboxd.controllers.dto.categoria.CategoriaRequest;
import com.atoserobson.betterboxd.controllers.dto.categoria.CategoriaResponse;
import com.atoserobson.betterboxd.entities.Categoria;
import com.atoserobson.betterboxd.repositories.CategoriaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoriaService {

        private final CategoriaRepository categoriaRepository;

        @Transactional
        public CategoriaResponse criar(CategoriaRequest request) {
                var categoria = new Categoria(request.nome());
                categoria = categoriaRepository.save(categoria);
                return new CategoriaResponse(categoria.getId(), categoria.getNome());
        }

}
