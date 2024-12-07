package com.marcos.build_and_run.controllers;

import com.marcos.build_and_run.dto.UsuarioDto;
import com.marcos.build_and_run.entities.Usuario;
import com.marcos.build_and_run.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("users")
public class UsuarioController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UsuarioDto createUsuarioDto){
        Long id = userService.createUser(createUsuarioDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> getUserById(@PathVariable Long id){
        UsuarioDto usuarioDto = userService.getUserById(id);
        return ResponseEntity.ok(usuarioDto);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }

}
