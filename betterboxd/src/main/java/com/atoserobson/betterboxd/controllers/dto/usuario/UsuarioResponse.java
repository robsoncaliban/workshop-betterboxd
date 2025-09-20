package com.atoserobson.betterboxd.controllers.dto.usuario;

import com.atoserobson.betterboxd.entities.Usuario;

public record UsuarioResponse(
        Long id,
        String nome,
        String email
){
    public UsuarioResponse(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail());
    }
}
