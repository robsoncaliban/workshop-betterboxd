package com.atoserobson.betterboxd.controllers.docs;

import org.springframework.http.ResponseEntity;

import com.atoserobson.betterboxd.controllers.dto.avaliacao.AvaliacaoRequest;
import com.atoserobson.betterboxd.controllers.dto.avaliacao.AvaliacaoResponse;
import com.atoserobson.betterboxd.controllers.exception.handler.ExceptionResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface AvaliacaoController {

        @Operation(summary = "Avaliar um filme", description = "Cria e retorna informações da avaliação")
        @ApiResponses({
                        @ApiResponse(responseCode = "201", description = "Avaliação realizada com sucesso", content = @Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = AvaliacaoResponse.class))),
                        @ApiResponse(responseCode = "404", description = "Usuário ou filme não encontrado", content = @Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = ExceptionResponse.class))),
                        @ApiResponse(responseCode = "400", description = "Request inválido", content = @Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = ExceptionResponse.class))),
        })
        ResponseEntity<AvaliacaoResponse> avaliarFilme(
                        @RequestBody(description = "Request para avaliar um filme", required = true) AvaliacaoRequest avaliacao);

}