package com.atoserobson.betterboxd.controllers.dto.avaliacao;

import com.atoserobson.betterboxd.controllers.dto.categoria.CategoriaMapper;
import com.atoserobson.betterboxd.controllers.dto.filme.FilmeRequest;
import com.atoserobson.betterboxd.controllers.dto.filme.FilmeResponse;
import com.atoserobson.betterboxd.controllers.dto.usuario.UsuarioResponse;
import com.atoserobson.betterboxd.entities.Avaliacao;
import com.atoserobson.betterboxd.entities.Filme;
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
                entidade.getComentario()
                );
    }

    public AvaliacaoFilmeResponse converterEmDtoComUsuario(Avaliacao entidade) {
        UsuarioResponse usuarioResponse = new UsuarioResponse(
                entidade.getUsuario().getId(),
                entidade.getUsuario().getNome(),
                entidade.getUsuario().getEmail()
        );
        AvaliacaoResponse avaliacaoResponse = converterEmDto(entidade);
        return new AvaliacaoFilmeResponse(
                usuarioResponse,
                avaliacaoResponse
        );
    }
}
