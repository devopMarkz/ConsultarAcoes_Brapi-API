package com.marcos.build_and_run.services;

import com.marcos.build_and_run.dto.AssociacaoContaAcaoDto;
import com.marcos.build_and_run.entities.Acao;
import com.marcos.build_and_run.entities.Conta;
import com.marcos.build_and_run.entities.ContaAcao;
import com.marcos.build_and_run.entities.ContaAcaoId;
import com.marcos.build_and_run.repositories.AcaoRepository;
import com.marcos.build_and_run.repositories.ContaAcaoRepository;
import com.marcos.build_and_run.repositories.ContaRepository;
import com.marcos.build_and_run.services.exceptions.AcaoInexistenteException;
import com.marcos.build_and_run.services.exceptions.ContaInexistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private AcaoRepository acaoRepository;

    @Autowired
    private ContaAcaoRepository contaAcaoRepository;

    public void associarAcao(Long id, AssociacaoContaAcaoDto dto) {
        Conta conta = contaRepository.findById(id).orElseThrow(() -> new ContaInexistenteException("Conta de id " + id + " inexistente."));
        Acao acao = acaoRepository.findById(dto.id()).orElseThrow(() -> new AcaoInexistenteException("Ação de id " + dto.id() + " inexistente."));
        ContaAcaoId contaAcaoId = new ContaAcaoId(conta.getId(), acao.getId());
        var entity = new ContaAcao(contaAcaoId, conta, acao, dto.quantity());
        contaAcaoRepository.save(entity);
    }
}
