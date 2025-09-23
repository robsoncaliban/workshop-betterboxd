package com.atoserobson.betterboxd.controllers.docs;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.atoserobson.betterboxd.controllers.dto.categoria.CategoriaRequest;
import com.atoserobson.betterboxd.controllers.dto.categoria.CategoriaResponse;
import com.atoserobson.betterboxd.controllers.dto.filme.FilmeResponse;
import com.atoserobson.betterboxd.controllers.exception.handler.ExceptionResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Categorias", description = "Operações relacionadas a categoria")
public interface CategoriaController {

        @Operation(summary = "Criar", description = "Cria e retorna a categoria")
        @ApiResponses({
                        @ApiResponse(responseCode = "201", description = "Categoria criada com sucesso", content = @Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = CategoriaResponse.class))),
                        @ApiResponse(responseCode = "409", description = "Conflito na criação", content = @Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = ExceptionResponse.class))),
                        @ApiResponse(responseCode = "422", description = "Request inválido", content = @Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = ExceptionResponse.class))),
        })
        ResponseEntity<CategoriaResponse> criar(
                        @RequestBody(description = "Request para criar uma categoria", required = true) CategoriaRequest request);

        @Operation(summary = "Buscar todos", description = "Busca por todas as categorias")
        @ApiResponses({
                        @ApiResponse(responseCode = "200", description = "Sucesso na busca por categorias", content = @Content(mediaType = "application/json;charset=UTF-8", array = @ArraySchema(schema = @Schema(implementation = CategoriaResponse.class)))),
        })
        ResponseEntity<List<CategoriaResponse>> buscarTodos();

        @Operation(summary = "Buscar filmes de categoria", description = "Busca por todos os filmes de categoria")
        @ApiResponses({
                        @ApiResponse(responseCode = "200", description = "Sucesso na busca por categorias", content = @Content(mediaType = "application/json;charset=UTF-8", array = @ArraySchema(schema = @Schema(implementation = FilmeResponse.class)))),
                        @ApiResponse(responseCode = "404", description = "Categoria não encontrada", content = @Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = ExceptionResponse.class))),
        })
        ResponseEntity<List<FilmeResponse>> buscarFilmesDeCategoria(
                        @Parameter(description = "ID da categoria", required = true, example = "1") Long id);

}
