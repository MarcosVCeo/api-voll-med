package br.com.marcosceola.api.dto.medico;

import br.com.marcosceola.api.dto.EnderecoUpdateForm;
import jakarta.validation.constraints.NotNull;

public record MedicoUpdateForm(
        @NotNull
        Long id,
        String nome,
        String telefone,
        EnderecoUpdateForm endereco) {
}