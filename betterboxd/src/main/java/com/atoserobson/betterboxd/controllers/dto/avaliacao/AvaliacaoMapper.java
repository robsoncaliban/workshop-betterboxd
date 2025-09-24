package com.atoserobson.betterboxd.controllers.dto.avaliacao;

import com.atoserobson.betterboxd.controllers.dto.usuario.UsuarioMapper;
import com.atoserobson.betterboxd.controllers.dto.usuario.UsuarioResponse;
import com.atoserobson.betterboxd.entities.Avaliacao;

import lombok.experimental.UtilityClass;

@UtilityClass
public class AvaliacaoMapper {

    public Avaliacao converterEmEntidade(AvaliacaoRequest request) {
        return new Avaliacao(request.nota(), request.comentario());
    }

    public AvaliacaoResponse converterEmDto(Avaliacao entidade) {
        return new AvaliacaoResponse(
                entidade.getFilme().getNome(),
                entidade.getNota(),
                entidade.getComentario());
    }

    public AvaliacaoFilmeResponse converterEmDtoComUsuario(Avaliacao entidade) {
        UsuarioResponse usuarioResponse = UsuarioMapper.converterEmDto(entidade.getUsuario());
        AvaliacaoResponse avaliacaoResponse = converterEmDto(entidade);
        return new AvaliacaoFilmeResponse(
                usuarioResponse,
                avaliacaoResponse);
    }
}
