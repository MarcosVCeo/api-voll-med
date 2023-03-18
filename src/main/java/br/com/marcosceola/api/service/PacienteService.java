package br.com.marcosceola.api.service;

import br.com.marcosceola.api.dto.paciente.PacienteUpdateForm;
import br.com.marcosceola.api.exception.ApiException;
import br.com.marcosceola.api.model.paciente.Paciente;
import br.com.marcosceola.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public void save(Paciente paciente) {
        pacienteRepository.save(paciente);
    }

    public Page<Paciente> listAll(Pageable paginacao) {
        return pacienteRepository.findAllByAtivoTrue(paginacao);
    }

    public Paciente find(Long id) {
        return pacienteRepository
                .findById(id)
                .orElseThrow(() -> new ApiException(String.format("Não foi possível encontrar um paciente com o id: '%d'", id)));
    }

    public void update(PacienteUpdateForm pacienteUpdateForm) {
        var paciente = find(pacienteUpdateForm.id());
        paciente.atualizarInformacoes(pacienteUpdateForm);
    }

    public void delete(Long id) {
       var paciente = find(id);
       paciente.desativar();
    }
}
