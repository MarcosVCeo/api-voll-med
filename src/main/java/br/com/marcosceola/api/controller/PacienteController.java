package br.com.marcosceola.api.controller;

import br.com.marcosceola.api.dto.paciente.DadosListagemPaciente;
import br.com.marcosceola.api.dto.paciente.PacienteForm;
import br.com.marcosceola.api.dto.paciente.PacienteUpdateForm;
import br.com.marcosceola.api.model.paciente.Paciente;
import br.com.marcosceola.api.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    @Transactional
    public void cadastrar(@Valid @RequestBody PacienteForm pacienteForm) {
        pacienteService.save(new Paciente(pacienteForm));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPaciente>> listar(@PageableDefault(sort = {"nome"}) Pageable paginacao) {
        var dadosPaciente = pacienteService
                .listAll(paginacao)
                .map(DadosListagemPaciente::new);

        return ResponseEntity.ok(dadosPaciente);
    }

    @PutMapping
    @Transactional
    public void update(@Valid @RequestBody PacienteUpdateForm pacienteUpdateForm) {
        pacienteService.update(pacienteUpdateForm);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        pacienteService.delete(id);
    }
}
