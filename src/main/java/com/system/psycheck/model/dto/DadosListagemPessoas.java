package com.system.psycheck.model.dto;

import com.system.psycheck.model.entity.Pessoa;

public record DadosListagemPessoas(
        Long codPessoa,
        String nome,
        String email,
        Boolean softDelete,
        String usuario,
        String senha) {
    public DadosListagemPessoas(Pessoa pessoa) {
        this(
                pessoa.getCodPessoa(),
                pessoa.getNome(),
                pessoa.getEmail(),
                pessoa.getSoftDelete(),
                pessoa.getUsuario(),
                pessoa.getSenha()
        );
    }
}
