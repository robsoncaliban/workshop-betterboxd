package com.atoserobson.betterboxd.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atoserobson.betterboxd.controllers.dto.categoria.CategoriaRequest;
import com.atoserobson.betterboxd.controllers.dto.categoria.CategoriaResponse;
import com.atoserobson.betterboxd.controllers.exception.EntityNotFoundException;
import com.atoserobson.betterboxd.entities.Categoria;
import com.atoserobson.betterboxd.repositories.CategoriaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoriaService {

        private final CategoriaRepository categoriaRepository;

        @Transactional
        public CategoriaResponse create(CategoriaRequest request) {
                // transforma o request em entidade
                var categoria = new Categoria(request.nome());

                // salva entidade
                categoria = categoriaRepository.save(categoria);

                // transforma a entidade em response
                var id = categoria.getId();
                var nome = categoria.getNome();
                var categoriaResponse = new CategoriaResponse(id, nome);

                return categoriaResponse;
        }

        protected Categoria getEntityById(Long id) {
                return categoriaRepository.findById(id)
                                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada"));
        }

}
