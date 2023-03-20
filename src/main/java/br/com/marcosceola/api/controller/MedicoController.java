package br.com.marcosceola.api.controller;

import br.com.marcosceola.api.dto.medico.DadosDetalhamentoMedico;
import br.com.marcosceola.api.dto.medico.DadosListagemMedico;
import br.com.marcosceola.api.dto.medico.MedicoForm;
import br.com.marcosceola.api.dto.medico.MedicoUpdateForm;
import br.com.marcosceola.api.model.medico.Medico;
import br.com.marcosceola.api.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@Valid @RequestBody MedicoForm medicoForm, UriComponentsBuilder uriBuilder) {
        var medico = medicoService.save(new Medico(medicoForm));
        var uri = uriBuilder
                .path("/medicos/{id}")
                .buildAndExpand(medico.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(sort = {"nome"}) Pageable paginacao) {
        var medicosForm = medicoService
                .listAll(paginacao)
                .map(DadosListagemMedico::new);

        return ResponseEntity.ok(medicosForm);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoMedico> buscar(@PathVariable Long id) {
        var medico = medicoService.findAtivo(id);

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        medicoService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@Valid @RequestBody MedicoUpdateForm medicoUpdateForm) {
        var medico = medicoService.update(medicoUpdateForm);

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }
}
