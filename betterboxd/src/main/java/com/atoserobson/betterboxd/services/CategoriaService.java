package com.atoserobson.betterboxd.services;

import org.springframework.stereotype.Service;

import com.atoserobson.betterboxd.controllers.exception.EntityNotFoundException;
import com.atoserobson.betterboxd.entities.Categoria;
import com.atoserobson.betterboxd.repositories.CategoriaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoriaService {

        private final CategoriaRepository categoriaRepository;

        protected Categoria getEntityById(Long id) {
                return categoriaRepository.findById(id)
                                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada"));
        }

}
