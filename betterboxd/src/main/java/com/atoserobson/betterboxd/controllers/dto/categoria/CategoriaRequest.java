package com.atoserobson.betterboxd.controllers.dto.categoria;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoriaRequest(

                @NotBlank @Size(min = 3, max = 32) String nome

) {

}
