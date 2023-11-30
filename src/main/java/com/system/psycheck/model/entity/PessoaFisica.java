package com.system.psycheck.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "PESSOA_FISICA")
public class PessoaFisica extends Pessoa {
    private LocalDate dataNasc;
    private String cpf;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "GENERO", referencedColumnName = "COD_GENERO", foreignKey = @ForeignKey(name = "FK_PF_GENERO"))
    private Genero genero;

    public PessoaFisica() {
        super("PF");
    }

    public PessoaFisica(Long codPessoa, String nome, String email, Boolean softDelete, String usuario, String senha, LocalDate dataNasc, String cpf, Genero genero) {
        super(codPessoa, nome, email, softDelete, usuario, senha, "PF");
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.genero = genero;
    }

    public PessoaFisica(String nome, String email, Boolean softDelete, String usuario, String senha, LocalDate dataNasc, String cpf, Genero genero) {
        super(nome, email, softDelete, usuario, senha, "PF");
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.genero = genero;
    }

    public PessoaFisica(String nome, String email, Boolean softDelete, String usuario, String senha, LocalDate dataNasc, String cpf, String genero) {
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public PessoaFisica setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public PessoaFisica setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public Genero getGenero() {
        return genero;
    }

    public PessoaFisica setGenero(Genero genero) {
        this.genero = genero;
        return this;
    }
}
