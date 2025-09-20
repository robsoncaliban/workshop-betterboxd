package com.atoserobson.betterboxd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atoserobson.betterboxd.entities.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

}
