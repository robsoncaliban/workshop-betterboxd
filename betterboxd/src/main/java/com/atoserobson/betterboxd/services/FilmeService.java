package com.atoserobson.betterboxd.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atoserobson.betterboxd.controllers.dto.avaliacao.AvaliacaoFilmeResponse;
import com.atoserobson.betterboxd.controllers.dto.avaliacao.AvaliacaoMapper;
import com.atoserobson.betterboxd.controllers.dto.filme.FilmeMapper;
import com.atoserobson.betterboxd.controllers.dto.filme.FilmeRequest;
import com.atoserobson.betterboxd.controllers.dto.filme.FilmeResponse;
import com.atoserobson.betterboxd.controllers.exception.EntidadeNaoEncontradaException;
import com.atoserobson.betterboxd.controllers.exception.ViolacaoIntegridadeDadosException;
import com.atoserobson.betterboxd.entities.Avaliacao;
import com.atoserobson.betterboxd.entities.Filme;
import com.atoserobson.betterboxd.repositories.FilmeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FilmeService {

        private final FilmeRepository filmeRepository;
        private final CategoriaService categoriaService;

        @Transactional
        public FilmeResponse criar(FilmeRequest request) {
                try {

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
                } catch (DataIntegrityViolationException e) {
                        throw new ViolacaoIntegridadeDadosException(
                                        String.format("Erro ao tentar criar '%s'", request.nome()));
                }
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

                var response = new ArrayList<FilmeResponse>();

                for (Filme filme : filmes) {
                        response.add(FilmeMapper.converterEmDto(filme));
                }

                return response;
        }

        @Transactional(readOnly = true)
        public List<AvaliacaoFilmeResponse> listarAvaliacoesDeUmFilme(Long idFilme) {
                Filme filme = buscarFilmePorId(idFilme);

                List<Avaliacao> avaliacoes = filme.getAvaliacoes();
                List<AvaliacaoFilmeResponse> response = new ArrayList<>();

                for (Avaliacao avaliacao : avaliacoes) {
                        AvaliacaoFilmeResponse avaliacaoResponse = AvaliacaoMapper.converterEmDtoComUsuario(avaliacao);
                        response.add(avaliacaoResponse);
                }
                return response;
        }

        @Transactional
        public void excluir(Long id) {
                var filme = buscarFilmePorId(id);
                filmeRepository.delete(filme);
        }

        public Filme buscarFilmePorId(Long id) {
                return filmeRepository.findById(id).orElseThrow(
                                () -> new EntidadeNaoEncontradaException("Filme não encontrado"));
        }

}
