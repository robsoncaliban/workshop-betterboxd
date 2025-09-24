package com.atoserobson.betterboxd.controllers.dto.avaliacao;

public record AvaliacaoResponse(
        String nomeFilme,
        Integer nota,
        String comentario
) {
}
