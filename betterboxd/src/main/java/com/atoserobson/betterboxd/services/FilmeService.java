package com.atoserobson.betterboxd.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atoserobson.betterboxd.controllers.dto.categoria.CategoriaResponse;
import com.atoserobson.betterboxd.controllers.dto.filme.FilmeMapper;
import com.atoserobson.betterboxd.controllers.dto.filme.FilmeRequest;
import com.atoserobson.betterboxd.controllers.dto.filme.FilmeResponse;
import com.atoserobson.betterboxd.repositories.FilmeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FilmeService {

        private final FilmeRepository filmeRepository;
        private final CategoriaService categoriaService;

        @Transactional
        public FilmeResponse criar(FilmeRequest request) {
                // transforma o request em entidade
                var filme = FilmeMapper.converterEmEntidade(request);

                // busca categoria por ID
                var categoria = categoriaService.buscarEntidadePorId(request.categoriaId());
                filme.setCategoria(categoria);

                // salva entidade
                filme = filmeRepository.save(filme);

                // transforma as entidades em responses
                var filmeResponse = FilmeMapper.converterEmDto(filme);

                return filmeResponse;
        }

        @Transactional(readOnly = true)
        public List<FilmeResponse> buscarTodos() {
                var filmes = filmeRepository.findAll();

                var response = filmes.stream().map(filme -> FilmeMapper.converterEmDto(filme)).toList();

                return response;
        }

        @Transactional(readOnly = true)
        public List<FilmeResponse> buscarPorNome(String nome) {
                var filmes = filmeRepository.findAllByNomeContainingIgnoreCase(nome);

                var response = filmes.stream().map(filme -> {
                        var categoriaResponse = new CategoriaResponse(
                                        filme.getCategoria().getId(),
                                        filme.getCategoria().getNome());
                        return new FilmeResponse(filme.getId(),
                                        filme.getNome(), filme.getUrlTrailer(), categoriaResponse);

                }).toList();

                return response;
        }

}
