package com.marcos.build_and_run.services;

import com.marcos.build_and_run.dto.UsuarioDto;
import com.marcos.build_and_run.entities.Usuario;
import com.marcos.build_and_run.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public Long createUser(UsuarioDto usuarioDto){
        var usuario = new Usuario(null, usuarioDto.username(), usuarioDto.email(), usuarioDto.password());
        var usuarioSalvo = usuarioRepository.save(usuario);
        return usuarioSalvo.getId();
    }

    @Transactional(readOnly = true)
    public UsuarioDto getUserById(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        Usuario result = usuario.orElseThrow(() -> new UsuarioInexistenteException("Usuário de ID " + id + " inexistente."));
        return new UsuarioDto(result.getId(), result.getUsername(), result.getEmail(), result.getPassword());
    }

    @Transactional(readOnly = true)
    public List<UsuarioDto> getAll(){
        return usuarioRepository.findAll()
                .stream()
                .map(usuario -> new UsuarioDto(usuario.getId(), usuario.getUsername(), usuario.getEmail(), usuario.getPassword())).toList();
    }

}
