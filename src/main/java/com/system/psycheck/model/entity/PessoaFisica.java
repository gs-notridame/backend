package com.system.psycheck.model.entity;

import com.system.psycheck.model.dto.DadosCadastroPaciente;
import jakarta.persistence.*;

import java.time.LocalDate;


@Table(name = "PESSOA_FISICA")
@Entity(name = "PESSOA_FISICA")
@DiscriminatorValue("PF")
public class PessoaFisica extends Pessoa {
    private LocalDate dataNasc;
    private String cpf;

    @OneToOne
    @JoinColumn(name = "COD_GENERO")
    private Genero genero;

    public PessoaFisica() {
    }

    public PessoaFisica(Long codPessoa, String nome, String email, Boolean softDelete, String usuario, String senha, LocalDate dataNasc, String cpf, Genero genero) {
        super(codPessoa, nome, email, softDelete, usuario, senha);
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.genero = genero;
    }

    public PessoaFisica(String nome, String email, Boolean softDelete, String usuario, String senha, LocalDate dataNasc, String cpf, Genero genero) {
        super(nome, email, softDelete, usuario, senha);
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
