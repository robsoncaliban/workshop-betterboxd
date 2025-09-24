package com.atoserobson.betterboxd.controllers.dto.filme;

import com.atoserobson.betterboxd.controllers.dto.categoria.CategoriaResponse;

public record FilmeResponse(

                Long id,
                String nome,
                String urlTrailer,
                CategoriaResponse categoria

) {

}
