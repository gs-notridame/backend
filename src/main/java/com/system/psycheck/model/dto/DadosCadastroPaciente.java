package com.system.psycheck.model.dto;

import com.system.psycheck.model.entity.Genero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record DadosCadastroPaciente(
        @NotBlank String historico,
        @NotBlank String numSeguroSaude,
        @NotBlank String nome,
        @NotBlank String email,
        @NotNull Boolean softDelete,
        @NotBlank String usuario,
        @NotBlank String senha,
        @NotNull LocalDate dataNasc,
        @NotBlank String cpf,
        @NotNull String genero
) {
}
