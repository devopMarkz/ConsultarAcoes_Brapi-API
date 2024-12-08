package com.marcos.build_and_run.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_acao")
public class Acao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acao_id")
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(unique = true)
    private String ticker;

    public Acao() {
    }

    public Acao(Long id, String description, String ticker) {
        this.id = id;
        this.description = description;
        this.ticker = ticker;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Acao acao = (Acao) object;
        return Objects.equals(id, acao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
