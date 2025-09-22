package com.atoserobson.betterboxd.controllers.dto.categoria;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoriaRequest(

                @Parameter(description = "Nome da categoria", required = true, example = "Ação") @NotBlank @Size(min = 3, max = 32) String nome

) {

}
