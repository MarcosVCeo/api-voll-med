package br.com.marcosceola.api.dto.medico;

import br.com.marcosceola.api.model.Endereco;
import br.com.marcosceola.api.model.medico.Especialidade;
import br.com.marcosceola.api.model.medico.Medico;

public record DadosDetalhamentoMedico(
        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        Endereco endereco) {

    public DadosDetalhamentoMedico(Medico medico) {
        this(
                medico.getId(),
                medico.getNome(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getEspecialidade(),
                medico.getEndereco());
    }
}
