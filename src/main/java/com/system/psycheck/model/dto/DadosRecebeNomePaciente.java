package com.system.psycheck.model.dto;

import com.system.psycheck.model.entity.Paciente;
import jakarta.validation.constraints.NotBlank;

public record DadosRecebeNomePaciente (
    @NotBlank
    Long codPaciente,
    @NotBlank
    String historico,
    @NotBlank
    String numSeguroSaude

){
    public DadosRecebeNomePaciente (Paciente paciente){
        this(
                paciente.getCodPaciente(),
                paciente.getHistorico(),
                paciente.getNumSeguroSaude()

        );
    }
}



