package com.marcos.build_and_run.controllers;

import com.marcos.build_and_run.dto.AcaoDto;
import com.marcos.build_and_run.dto.UsuarioDto;
import com.marcos.build_and_run.services.AcaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/acoes")
public class AcaoController {

    @Autowired
    private AcaoService acaoService;

    @PostMapping
    public ResponseEntity<Void> createAcao(@RequestBody AcaoDto createAcaoDto){
        createAcaoDto = acaoService.createAcao(createAcaoDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createAcaoDto.id())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
