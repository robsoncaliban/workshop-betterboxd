package com.atoserobson.betterboxd.services;

import com.atoserobson.betterboxd.controllers.dto.avaliacao.AvaliacaoMapper;
import com.atoserobson.betterboxd.controllers.dto.avaliacao.AvaliacaoResponse;
import com.atoserobson.betterboxd.controllers.dto.usuario.UsuarioMapper;
import com.atoserobson.betterboxd.controllers.dto.usuario.UsuarioRequest;
import com.atoserobson.betterboxd.controllers.dto.usuario.UsuarioResponse;
import com.atoserobson.betterboxd.controllers.exception.EntidadeNaoEncontradaException;
import com.atoserobson.betterboxd.controllers.exception.ViolacaoIntegridadeDadosException;
import com.atoserobson.betterboxd.entities.Avaliacao;
import com.atoserobson.betterboxd.entities.Usuario;
import com.atoserobson.betterboxd.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioResponse criarUsuario(UsuarioRequest usuarioRequest){
        Usuario usuario = UsuarioMapper.converterEmEntidade(usuarioRequest);
        try {
            usuario = usuarioRepository.save(usuario);
        }catch (DataIntegrityViolationException e) {
            throw new ViolacaoIntegridadeDadosException("Email: este email já está em uso");
        }
        return UsuarioMapper.converterEmDto(usuario);
    }

    public List<UsuarioResponse> listarUsuarios(){

        return usuarioRepository.findAll()
                    .stream().map(
                        (usuario) -> UsuarioMapper.converterEmDto(usuario)).toList();
    }

    public List<AvaliacaoResponse> listarAvaliacoesDeUmUsuario(Long idUsuario){
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        List<Avaliacao> avaliacoes = usuario.getAvaliacoes();
        List<AvaliacaoResponse> response = new ArrayList<>();
        for(Avaliacao avaliacao : avaliacoes){
            AvaliacaoResponse avaliacaoResponse = AvaliacaoMapper.converterEmDto(avaliacao);
            response.add(avaliacaoResponse);
        }
        return response;
    }

    public Usuario buscarUsuarioPorId(Long idUsuario){
        return usuarioRepository.findById(idUsuario).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Usuario não encontrado")
        );
    }

    public Usuario buscarUsuarioPorEmail(String email){
        return usuarioRepository.findByEmail(email).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Usuario não encontrado")
        );
    }

}
