package br.com.marcosceola.api.controller;

import br.com.marcosceola.api.dto.paciente.PacienteForm;
import br.com.marcosceola.api.model.paciente.Paciente;
import br.com.marcosceola.api.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public void cadastrar(@RequestBody PacienteForm pacienteForm) {
        pacienteService.save(new Paciente(pacienteForm));
    }
}
