package br.com.marcosceola.api.dto.medico;

import br.com.marcosceola.api.model.medico.Especialidade;
import br.com.marcosceola.api.model.medico.Medico;

public record DadosListagemMedico(
        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade) {

    public DadosListagemMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
