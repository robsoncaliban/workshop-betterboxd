package com.atoserobson.betterboxd.controllers.docs;

import java.util.List;

import com.atoserobson.betterboxd.controllers.dto.avaliacao.AvaliacaoFilmeResponse;
import com.atoserobson.betterboxd.controllers.dto.usuario.UsuarioResponse;
import org.springframework.http.ResponseEntity;

import com.atoserobson.betterboxd.controllers.dto.filme.FilmeRequest;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "Filmes", description = "Operações relacionadas a filme")
public interface FilmeController {

        @Operation(summary = "Criar", description = "Cria e retorna o filme")
        @ApiResponses({
                        @ApiResponse(responseCode = "201", description = "Filme criado com sucesso", content = @Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = FilmeResponse.class))),
                        @ApiResponse(responseCode = "409", description = "Conflito na criação", content = @Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = ExceptionResponse.class))),
                        @ApiResponse(responseCode = "400", description = "Request inválido", content = @Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = ExceptionResponse.class))),
        })
        ResponseEntity<FilmeResponse> criar(
                        @RequestBody(description = "Request para criar um filme", required = true) FilmeRequest request);

        @Operation(summary = "Buscar todos", description = "Busca por todos os filmes, com ou sem filtro")
        @ApiResponses({
                        @ApiResponse(responseCode = "200", description = "Sucesso na busca por filmes", content = @Content(mediaType = "application/json;charset=UTF-8", array = @ArraySchema(schema = @Schema(implementation = FilmeResponse.class)))),
        })
        ResponseEntity<List<FilmeResponse>> buscarTodos();

        ResponseEntity<List<FilmeResponse>> buscarPorNome(
                        @Parameter(description = "Nome para filtrar", required = false, example = "como") String nome);

        @Operation(summary = "Listar avaliações de um filme", description = "Retorna uma lista com todas as avaliações de um filme")
        @ApiResponses({
                @ApiResponse(
                        responseCode = "200",
                        description = "Listagem feita com sucesso",
                        content = @Content(mediaType = "application/json;charset=UTF-8",
                        array = @ArraySchema(schema = @Schema(implementation = AvaliacaoFilmeResponse.class)))),
                @ApiResponse(
                        responseCode = "404",
                        description = "Filme não encontrado",
                        content = @Content(mediaType = "application/json;charset=UTF-8",
                        schema = @Schema(implementation = ExceptionResponse.class)))
        })
        ResponseEntity<List<AvaliacaoFilmeResponse>> buscarAvaliacoesDeUmFilme(
                @Parameter(description = "ID do filme", example = "1")
                Long id);
}
