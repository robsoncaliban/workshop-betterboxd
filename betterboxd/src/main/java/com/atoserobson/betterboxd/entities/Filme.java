package com.atoserobson.betterboxd.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "filmes")
public class Filme implements Serializable {

        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(unique = true, nullable = false)
        private String nome;

        @Column(nullable = false)
        private String descricao;

        @Column(nullable = false)
        private String urlTrailer;

        @ManyToOne
        @JoinColumn(name = "categoria_id", nullable = false)
        private Categoria categoria;

        @OneToMany(mappedBy = "filme", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Avaliacao> avaliacoes;

        public Filme(String nome, String descricao, String urlTrailer) {
                this.nome = nome;
                this.descricao = descricao;
                this.urlTrailer = urlTrailer;
        }

}
