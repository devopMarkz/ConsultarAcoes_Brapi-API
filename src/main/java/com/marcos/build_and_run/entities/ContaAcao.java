package com.marcos.build_and_run.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_conta_estoque")
public class ContaAcao {

    @EmbeddedId
    private ContaAcaoId id;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    @MapsId("contaId")
    private Conta conta;

    @ManyToOne
    @JoinColumn(name = "acao_id")
    @MapsId("acaoId")
    private Acao acao;

    @Column(name = "quantity")
    private Integer quantity;

    public ContaAcao() {
    }

    public ContaAcao(ContaAcaoId id, Conta conta, Acao acao, Integer quantity) {
        this.id = id;
        this.conta = conta;
        this.acao = acao;
        this.quantity = quantity;
    }

    public ContaAcaoId getId() {
        return id;
    }

    public void setId(ContaAcaoId id) {
        this.id = id;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Acao getAcao() {
        return acao;
    }

    public void setAcao(Acao acao) {
        this.acao = acao;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
