package com.marcos.build_and_run.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_enderecodacobranca")
public class EnderecoDeCobranca {

    @Id
    @Column(name = "conta_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "conta_id")
    @MapsId
    private Conta conta;

    private String rua;

    private Integer numero;

    public EnderecoDeCobranca() {
    }

    public EnderecoDeCobranca(Long id, Conta conta, String rua, Integer numero) {
        this.id = id;
        this.conta = conta;
        this.rua = rua;
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        EnderecoDeCobranca that = (EnderecoDeCobranca) object;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
