package com.atoserobson.betterboxd.controllers.dto.avaliacao;

import com.atoserobson.betterboxd.controllers.dto.usuario.UsuarioResponse;

public record AvaliacaoFilmeResponse(
        UsuarioResponse usuario,
        AvaliacaoResponse avaliacao
) {
}
