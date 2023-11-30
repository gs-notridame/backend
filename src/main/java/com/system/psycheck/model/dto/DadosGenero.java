package com.system.psycheck.model.dto;

import jakarta.validation.constraints.NotNull;

public record DadosGenero(
        @NotNull String genero
) {
}
