package com.atoserobson.betterboxd.controllers.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioRequest(
        @NotBlank
        @Size(min = 5, max = 64)
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Size(min = 5, max = 32)
        String senha
) {}
