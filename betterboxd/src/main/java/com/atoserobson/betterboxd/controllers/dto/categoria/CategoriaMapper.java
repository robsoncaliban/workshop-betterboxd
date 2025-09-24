package com.atoserobson.betterboxd.controllers.dto.categoria;

import com.atoserobson.betterboxd.entities.Categoria;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoriaMapper {

        public Categoria converterEmEntidade(CategoriaRequest request) {
                return new Categoria(request.nome());
        }

        public CategoriaResponse converterEmDto(Categoria entidade) {
                return new CategoriaResponse(entidade.getId(), entidade.getNome());
        }

}
