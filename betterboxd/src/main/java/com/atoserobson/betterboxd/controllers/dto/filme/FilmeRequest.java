package com.atoserobson.betterboxd.controllers.dto.filme;

import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record FilmeRequest(

                @NotBlank String nome,
                @NotBlank @Size(min = 5, max = 255) String descricao,
                @NotBlank @URL String urlTrailer,
                @NotNull Long categoriaId

) {

}
