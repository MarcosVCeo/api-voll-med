package br.com.marcosceola.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MedicoUpdateForm(
        @NotNull
        Long id,

        @NotBlank
        String nome,

        @NotBlank
        String telefone,

        @NotNull
        @Valid
        EnderecoForm endereco) {
}