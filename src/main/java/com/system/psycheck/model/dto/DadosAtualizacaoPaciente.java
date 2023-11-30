package com.system.psycheck.model.dto;

import com.system.psycheck.model.entity.PessoaFisica;

public record DadosAtualizacaoPaciente(
        Long codPaciente,
        String historico,
        String numSeguroSaude,
        PessoaFisica pessoa
) {

}
