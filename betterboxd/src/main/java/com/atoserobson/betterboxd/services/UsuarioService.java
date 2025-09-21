package com.atoserobson.betterboxd.services;

import com.atoserobson.betterboxd.controllers.dto.usuario.UsuarioRequest;
import com.atoserobson.betterboxd.controllers.dto.usuario.UsuarioResponse;
import com.atoserobson.betterboxd.entities.Usuario;
import com.atoserobson.betterboxd.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioResponse criarUsuario(UsuarioRequest usuarioRequest){
        Usuario usuario = new Usuario(usuarioRequest);
        try {
            usuario = usuarioRepository.save(usuario);
        }catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Email: este email já está em uso");
        }
        return new UsuarioResponse(usuario);
    }

    public List<UsuarioResponse> listarUsuarios(){
        return usuarioRepository.findAll()
                    .stream().map(UsuarioResponse::new).toList();
    }

}
