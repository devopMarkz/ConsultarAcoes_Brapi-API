package com.marcos.build_and_run.controllers;

import com.marcos.build_and_run.dto.AcaoDto;
import com.marcos.build_and_run.dto.AssociacaoContaAcaoDto;
import com.marcos.build_and_run.dto.ContaDto;
import com.marcos.build_and_run.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @PostMapping("/{id}/acoes")
    public ResponseEntity<Void> associarAcao(@PathVariable("id") Long id, @RequestBody AssociacaoContaAcaoDto dto){
        contaService.associarAcao(id, dto);
        return ResponseEntity.ok().build();
    }

}
