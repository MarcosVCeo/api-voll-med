package br.com.marcosceola.api.dto.paciente;

import br.com.marcosceola.api.dto.EnderecoUpdateForm;
import jakarta.validation.constraints.NotNull;

public record PacienteUpdateForm(
        @NotNull
        Long id,
        String nome,
        String telefone,
        EnderecoUpdateForm endereco) {
}
