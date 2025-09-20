package com.atoserobson.betterboxd.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

        private Categoria categoria;

        public Filme(String nome, String descricao, String urlTrailer, Categoria categoria) {
                this.nome = nome;
                this.descricao = descricao;
                this.urlTrailer = urlTrailer;
                this.categoria = categoria;
        }

}
