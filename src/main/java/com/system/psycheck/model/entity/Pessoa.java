package com.system.psycheck.model.entity;

import jakarta.persistence.*;

@Table(name = "PESSOA")
@Entity(name = "PESSOA")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TIPO")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PESSOA")
    @SequenceGenerator(name = "SQ_PESSOA", sequenceName = "SQ_PESSOA", allocationSize = 1, initialValue = 1)
    @Column(name = "COD_PESSOA")
    private Long codPessoa;
    private String nome;
    private String email;
    private Boolean softDelete;
    private String usuario;
    private String senha;


    public Pessoa() {
    }

    public Pessoa(Long codPessoa, String nome, String email, Boolean softDelete, String usuario, String senha) {
        this.codPessoa = codPessoa;
        this.nome = nome;
        this.email = email;
        this.softDelete = softDelete;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Pessoa(String nome, String email, Boolean softDelete, String usuario, String senha) {
        this.nome = nome;
        this.email = email;
        this.softDelete = softDelete;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Long getCodPessoa() {
        return codPessoa;
    }

    public Pessoa setCodPessoa(Long codPessoa) {
        this.codPessoa = codPessoa;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Pessoa setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Pessoa setEmail(String email) {
        this.email = email;
        return this;
    }

    public Boolean getSoftDelete() {
        return softDelete;
    }

    public Pessoa setSoftDelete(Boolean softDelete) {
        this.softDelete = softDelete;
        return this;
    }

    public String getUsuario() {
        return usuario;
    }

    public Pessoa setUsuario(String usuario) {
        this.usuario = usuario;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public Pessoa setSenha(String senha) {
        this.senha = senha;
        return this;
    }
}
