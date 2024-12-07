package com.marcos.build_and_run.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conta_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToOne(mappedBy = "conta")
    @PrimaryKeyJoinColumn
    private EnderecoDeCobranca enderecoDeCobranca;

    @OneToMany(mappedBy = "conta")
    private List<ContaAcao> contaAcoes;

    public Conta() {
    }

    public Conta(Long id, String description, Usuario usuario) {
        this.id = id;
        this.description = description;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EnderecoDeCobranca getEnderecoDeCobranca() {
        return enderecoDeCobranca;
    }

    public List<ContaAcao> getContaAcoes() {
        return contaAcoes;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Conta conta = (Conta) object;
        return Objects.equals(id, conta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
