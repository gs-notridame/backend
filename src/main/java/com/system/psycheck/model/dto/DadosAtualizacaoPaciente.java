package com.system.psycheck.model.dto;

import com.system.psycheck.model.entity.Genero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record DadosAtualizacaoPaciente (

        Long codPaciente,
   String historico,
   String numSeguroSaude,
   String nome,
   String email,
   Boolean softDelete,
   String usuario,
   String senha,
   Genero genero,
   LocalDate dataNasc,
   String cpf
    ){

}
