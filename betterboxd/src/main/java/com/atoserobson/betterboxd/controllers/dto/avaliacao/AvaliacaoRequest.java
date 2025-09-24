package com.atoserobson.betterboxd.controllers.dto.avaliacao;

import jakarta.validation.constraints.*;

public record AvaliacaoRequest(
        @NotNull
        @Positive
        Long idFilme,
        @Email
        @NotBlank
        String emailUsuario,
        @Min(1)
        @Max(5)
        @NotNull
        Integer nota,
        @NotBlank
        @Size(min = 1, max = 255)
        String comentario
) {}