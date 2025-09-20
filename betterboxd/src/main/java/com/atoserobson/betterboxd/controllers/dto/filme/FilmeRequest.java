package com.atoserobson.betterboxd.controllers.dto.filme;

import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FilmeRequest(

                @NotBlank String nome,
                @NotBlank @Min(5) @Max(255) String descricao,
                @NotBlank @URL String urlTrailer,
                @NotNull Long categoriaId

) {

}
