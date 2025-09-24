package com.atoserobson.betterboxd.services;

import com.atoserobson.betterboxd.controllers.dto.avaliacao.AvaliacaoMapper;
import com.atoserobson.betterboxd.controllers.dto.avaliacao.AvaliacaoRequest;
import com.atoserobson.betterboxd.controllers.dto.avaliacao.AvaliacaoResponse;
import com.atoserobson.betterboxd.entities.Avaliacao;
import com.atoserobson.betterboxd.entities.Filme;
import com.atoserobson.betterboxd.entities.Usuario;
import com.atoserobson.betterboxd.repositories.AvaliacaoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AvaliacaoService {

    private final UsuarioService usuarioService;
    private AvaliacaoRepository avaliacaoRepository;
    private FilmeService filmeService;

    @Transactional
    public AvaliacaoResponse avaliarFilme(AvaliacaoRequest request) {
        Usuario usuario = usuarioService.buscarUsuarioPorEmail(request.emailUsuario());
        Filme filme = filmeService.buscarFilmePorId(request.idFilme());
        Avaliacao avaliacao = AvaliacaoMapper.converterEmEntidade(request);
        avaliacao.setUsuario(usuario);
        avaliacao.setFilme(filme);

        Avaliacao avaliacaoSava = avaliacaoRepository.save(avaliacao);
        return new AvaliacaoResponse(avaliacaoSava.getFilme().getNome(), avaliacaoSava.getNota(), avaliacaoSava.getComentario());
    }
}
