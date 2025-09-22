package com.atoserobson.betterboxd.controllers.dto.filme;

import org.hibernate.validator.constraints.URL;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record FilmeRequest(

                @Parameter(description = "Nome do filme", required = true, example = "Como treinar seu dragão") @NotBlank String nome,
                @Parameter(description = "Descrição do filme", required = true, example = "Sinopse do filme...") @NotBlank @Size(min = 5, max = 255) String descricao,
                @Parameter(description = "URL do trailer do filme", required = true, example = "www.youtube.com/como-treinar-seu-dragao") @NotBlank @URL String urlTrailer,
                @Parameter(description = "ID da categoria do filme", required = true, example = "1") @NotNull Long categoriaId

) {

}
