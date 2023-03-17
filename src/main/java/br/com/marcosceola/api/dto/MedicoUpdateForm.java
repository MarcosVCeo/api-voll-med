package br.com.marcosceola.api.dto;

import jakarta.validation.constraints.NotNull;

public record MedicoUpdateForm(
        @NotNull
        Long id,
        String nome,
        String telefone,
        EnderecoUpdateForm endereco) {
}