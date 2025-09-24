package com.atoserobson.betterboxd.controllers;

import com.atoserobson.betterboxd.controllers.docs.AvaliacaoController;
import com.atoserobson.betterboxd.controllers.dto.avaliacao.AvaliacaoRequest;
import com.atoserobson.betterboxd.controllers.dto.avaliacao.AvaliacaoResponse;
import com.atoserobson.betterboxd.services.AvaliacaoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "avaliacoes")
@AllArgsConstructor
public class AvaliacaoControllerImpl implements AvaliacaoController {
    private AvaliacaoService avaliacaoService;

    @PostMapping
    public ResponseEntity<AvaliacaoResponse> avaliarFilme(@RequestBody @Valid AvaliacaoRequest avaliacao) {
        AvaliacaoResponse response = avaliacaoService.avaliarFilme(avaliacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
