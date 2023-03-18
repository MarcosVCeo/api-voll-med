package br.com.marcosceola.api.dto.paciente;

import br.com.marcosceola.api.model.paciente.Paciente;

public record DadosListagemPaciente(String nome, String Email, String cpf) {

    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
