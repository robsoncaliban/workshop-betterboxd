package com.atoserobson.betterboxd.controllers;

import com.atoserobson.betterboxd.controllers.docs.UsuarioController;
import com.atoserobson.betterboxd.controllers.dto.avaliacao.AvaliacaoResponse;
import com.atoserobson.betterboxd.controllers.dto.usuario.UsuarioRequest;
import com.atoserobson.betterboxd.controllers.dto.usuario.UsuarioResponse;
import com.atoserobson.betterboxd.services.UsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
@AllArgsConstructor
public class UsuarioControllerImpl implements UsuarioController {

    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponse> criarUsuario(@RequestBody @Valid UsuarioRequest usuarioRequest) {
        UsuarioResponse response = usuarioService.criarUsuario(usuarioRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> listarUsuarios() {
        List<UsuarioResponse> response = usuarioService.listarUsuarios();
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id}/avaliacoes")
    public ResponseEntity<List<AvaliacaoResponse>> listarAvaliacoesDeUmUsuario(@PathVariable Long id) {
        List<AvaliacaoResponse> response = usuarioService.listarAvaliacoesDeUmUsuario(id);
        return ResponseEntity.ok(response);
    }
}
