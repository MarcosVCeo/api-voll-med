package br.com.marcosceola.api.dto;

import br.com.marcosceola.api.model.Especialidade;

public record MedicoForm(
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        EnderecoForm endereco) {
}
