package com.marcos.build_and_run.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ContaAcaoId {

    @Column(name = "conta_id")
    private Long contaId;

    @Column(name = "acao_id")
    private Long acaoId;

    public ContaAcaoId() {
    }

    public ContaAcaoId(Long contaId, Long acaoId) {
        this.contaId = contaId;
        this.acaoId = acaoId;
    }

    public Long getContaId() {
        return contaId;
    }

    public void setContaId(Long contaId) {
        this.contaId = contaId;
    }

    public Long getAcaoId() {
        return acaoId;
    }

    public void setAcaoId(Long acaoId) {
        this.acaoId = acaoId;
    }
}
