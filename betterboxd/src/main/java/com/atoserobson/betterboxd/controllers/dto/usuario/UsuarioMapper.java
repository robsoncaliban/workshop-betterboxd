package com.atoserobson.betterboxd.controllers.dto.usuario;

import com.atoserobson.betterboxd.entities.Usuario;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UsuarioMapper {

    public Usuario converterEmEntidade(UsuarioRequest request) {
        return new Usuario(request.nome(), request.email(), request.senha());
    }

    public UsuarioResponse converterEmDto(Usuario entidade) {
        return new UsuarioResponse(entidade.getId(), entidade.getNome(), entidade.getEmail());

    }
}
