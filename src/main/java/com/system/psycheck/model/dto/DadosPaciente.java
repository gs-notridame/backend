package com.system.psycheck.model.dto;

import com.system.psycheck.model.entity.Paciente;
import com.system.psycheck.model.entity.PessoaFisica;
import jakarta.validation.constraints.NotBlank;

public record DadosPaciente(
    @NotBlank
    Long codPaciente,
    @NotBlank
    String historico,
    @NotBlank
    String numSeguroSaude,

    PessoaFisica pessoa

){
    public DadosPaciente(Paciente paciente){
        this(
                paciente.getCodPaciente(),
                paciente.getHistorico(),
                paciente.getNumSeguroSaude(),
                paciente.getPessoa()

        );
    }
}



