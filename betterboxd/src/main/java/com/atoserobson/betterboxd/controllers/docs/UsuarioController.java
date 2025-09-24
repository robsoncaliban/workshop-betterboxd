package com.atoserobson.betterboxd.controllers.docs;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.atoserobson.betterboxd.controllers.dto.avaliacao.AvaliacaoResponse;
import com.atoserobson.betterboxd.controllers.dto.usuario.UsuarioRequest;
import com.atoserobson.betterboxd.controllers.dto.usuario.UsuarioResponse;
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

@Tag(name = "Usuarios", description = "Operações relacionadas a usuarios")
public interface UsuarioController {

        @Operation(summary = "Criar usuario", description = "Cria e retorna informações do usuario")
        @ApiResponses({
                        @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso", content = @Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = UsuarioResponse.class))),
                        @ApiResponse(responseCode = "409", description = "Conflito na criação", content = @Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = ExceptionResponse.class))),
                        @ApiResponse(responseCode = "400", description = "Request inválido", content = @Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = ExceptionResponse.class))),
        })
        ResponseEntity<UsuarioResponse> criarUsuario(
                        @RequestBody(description = "Request para criar um usuarios", required = true) UsuarioRequest usuarioRequest);

        @Operation(summary = "Listar todos os usuarios", description = "Retorna uma lista com todos os usuarios")
        @ApiResponses({
                        @ApiResponse(responseCode = "200", description = "Sucesso ao listar usuarios", content = @Content(mediaType = "application/json;charset=UTF-8", array = @ArraySchema(schema = @Schema(implementation = UsuarioResponse.class)))),
        })
        ResponseEntity<List<UsuarioResponse>> listarUsuarios();

        @Operation(summary = "Listar avaliações de um usuario", description = "Retorna uma lista com todas as avaliações de um usuario")
        @ApiResponses({
                        @ApiResponse(responseCode = "200", description = "Usuário criado com sucesso", content = @Content(mediaType = "application/json;charset=UTF-8", array = @ArraySchema(schema = @Schema(implementation = AvaliacaoResponse.class)))),
                        @ApiResponse(responseCode = "404", description = "Usuario não encontrado", content = @Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = ExceptionResponse.class))),
        })
        ResponseEntity<List<AvaliacaoResponse>> listarAvaliacoesDeUmUsuario(
                        @Parameter(description = "ID do usuário", example = "1") Long id);
}
