package br.com.marcosceola.api.service;

import br.com.marcosceola.api.model.paciente.Paciente;
import br.com.marcosceola.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public void save(Paciente paciente) {
        pacienteRepository.save(paciente);
    }
}
