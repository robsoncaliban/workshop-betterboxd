package com.atoserobson.betterboxd.repositories;

import com.atoserobson.betterboxd.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
