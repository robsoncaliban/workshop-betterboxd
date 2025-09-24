package com.atoserobson.betterboxd.repositories;

import com.atoserobson.betterboxd.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    Long id(Long id);
}
