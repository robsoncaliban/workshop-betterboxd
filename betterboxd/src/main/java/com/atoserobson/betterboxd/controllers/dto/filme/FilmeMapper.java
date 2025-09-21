package com.atoserobson.betterboxd.controllers.dto.filme;

import com.atoserobson.betterboxd.controllers.dto.categoria.CategoriaMapper;
import com.atoserobson.betterboxd.entities.Filme;

import lombok.experimental.UtilityClass;

@UtilityClass
public class FilmeMapper {

        public Filme converterEmEntidade(FilmeRequest request) {
                return new Filme(request.nome(), request.descricao(), request.urlTrailer());
        }

        public FilmeResponse converterEmDto(Filme entidade) {
                var categoriaResponse = CategoriaMapper.converterEmDto(entidade.getCategoria());
                return new FilmeResponse(entidade.getId(),
                                entidade.getNome(),
                                entidade.getUrlTrailer(),
                                categoriaResponse);

        }

}
