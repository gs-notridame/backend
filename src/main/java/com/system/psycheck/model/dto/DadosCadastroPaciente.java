package com.system.psycheck.model.dto;

import com.system.psycheck.model.entity.PessoaFisica;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPaciente(
        @NotBlank String historico,
        @NotBlank String numSeguroSaude,
        @NotNull PessoaFisica pessoa
) {
}
