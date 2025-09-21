package com.atoserobson.betterboxd.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atoserobson.betterboxd.entities.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

        List<Filme> findAllByNomeContainingIgnoreCase(String nome);

}
