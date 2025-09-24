package com.atoserobson.betterboxd.entities;

import com.atoserobson.betterboxd.controllers.dto.usuario.UsuarioRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length =  64, nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(length = 32, nullable = false)
    private String senha;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Avaliacao> avaliacoes;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    public Usuario(UsuarioRequest usuarioRequest) {
        this.nome = usuarioRequest.nome();
        this.email = usuarioRequest.email();
        this.senha = usuarioRequest.senha();
    }
}
