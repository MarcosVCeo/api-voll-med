package br.com.marcosceola.api.dto;

import br.com.marcosceola.api.model.Especialidade;
import br.com.marcosceola.api.model.Medico;

public record DadosListagemMedico(
        String nome,
        String email,
        String crm,
        Especialidade especialidade) {

    public DadosListagemMedico(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
