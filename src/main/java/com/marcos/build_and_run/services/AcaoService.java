package com.marcos.build_and_run.services;

import com.marcos.build_and_run.dto.AcaoDto;
import com.marcos.build_and_run.entities.Acao;
import com.marcos.build_and_run.repositories.AcaoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AcaoService {

    @Autowired
    private AcaoRepository acaoRepository;

    @Transactional
    public AcaoDto createAcao(AcaoDto createAcaoDto) {
        Acao acao = new Acao();
        acao.setDescription(createAcaoDto.description());
        acao.setTicker(createAcaoDto.ticker());
        acao = acaoRepository.save(acao);
        return new AcaoDto(acao.getId(), acao.getDescription(), acao.getTicker());
    }
}
