package com.atoserobson.betterboxd.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "filme_id", nullable = false)
    private Filme filme;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private Integer nota;

    private String comentario;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime data;

    public Avaliacao(Filme filme, Usuario usuario, Integer nota, String comentario) {
        this.filme = filme;
        this.usuario = usuario;
        this.nota = nota;
        this.comentario = comentario;
        this.data = LocalDateTime.now();
    }

    public Avaliacao(Integer nota, String comentario) {
        this.nota = nota;
        this.comentario = comentario;
        this.data = LocalDateTime.now();
    }
}
