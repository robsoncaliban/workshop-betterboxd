package com.atoserobson.betterboxd.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atoserobson.betterboxd.controllers.dto.categoria.CategoriaMapper;
import com.atoserobson.betterboxd.controllers.dto.categoria.CategoriaRequest;
import com.atoserobson.betterboxd.controllers.dto.categoria.CategoriaResponse;
import com.atoserobson.betterboxd.controllers.dto.filme.FilmeMapper;
import com.atoserobson.betterboxd.controllers.dto.filme.FilmeResponse;
import com.atoserobson.betterboxd.controllers.exception.EntityNotFoundException;
import com.atoserobson.betterboxd.entities.Categoria;
import com.atoserobson.betterboxd.repositories.CategoriaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoriaService {

        private final CategoriaRepository categoriaRepository;

        @Transactional
        public CategoriaResponse criar(CategoriaRequest request) {
                // transforma o request em entidade
                var categoria = CategoriaMapper.converterEmEntidade(request);

                // salva entidade
                categoria = categoriaRepository.save(categoria);

                // transforma a entidade em response
                var response = CategoriaMapper.converterEmDto(categoria);

                return response;
        }

        @Transactional(readOnly = true)
        public List<CategoriaResponse> buscarTodos() {
                var categorias = categoriaRepository.findAll();

                var response = categorias.stream()
                                .map(categoria -> CategoriaMapper.converterEmDto(categoria))
                                .toList();

                return response;
        }

        @Transactional(readOnly = true)
        public List<FilmeResponse> buscarFilmesDeCategoria(Long id) {
                var categoria = buscarEntidadePorId(id);

                var response = categoria.getFilmes().stream().map(filme -> FilmeMapper.converterEmDto(filme)).toList();

                return response;
        }

        protected Categoria buscarEntidadePorId(Long id) {
                return categoriaRepository.findById(id)
                                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada"));
        }

}
