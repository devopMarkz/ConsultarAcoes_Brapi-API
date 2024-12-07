package com.marcos.build_and_run.controllers;

import com.marcos.build_and_run.dto.ContaDto;
import com.marcos.build_and_run.dto.UsuarioDto;
import com.marcos.build_and_run.services.UserService;
import jakarta.validation.Valid;
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
    public ResponseEntity<Void> createUser(@Valid @RequestBody UsuarioDto createUsuarioDto){
        Long id = userService.createUser(createUsuarioDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}/contas")
    public ResponseEntity<List<ContaDto>> listarContas(@PathVariable Long id){
        var contas = userService.listarContas(id);
        return ResponseEntity.ok(contas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> getUserById(@PathVariable Long id){
        UsuarioDto usuarioDto = userService.getUserById(id);
        return ResponseEntity.ok(usuarioDto);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> listUsers(){
        return ResponseEntity.ok(userService.listUsers());
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateById(@PathVariable Long id ,@RequestBody UsuarioDto usuarioDto){
        userService.updateUserById(id, usuarioDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/contas")
    public ResponseEntity<Void> criarConta(@PathVariable("id") Long id, @RequestBody ContaDto contaDto){
        userService.criarConta(id, contaDto);
        return ResponseEntity.ok().build();
    }

}
