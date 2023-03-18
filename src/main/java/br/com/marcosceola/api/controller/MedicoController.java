package br.com.marcosceola.api.controller;

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

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    @Transactional
    public void cadastrar(@Valid @RequestBody MedicoForm medicoForm) {
        medicoService.save(new Medico(medicoForm));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(sort = {"nome"}) Pageable paginacao) {
        var medicosForm = medicoService
                .listAll(paginacao)
                .map(DadosListagemMedico::new);

        return ResponseEntity.ok(medicosForm);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        medicoService.delete(id);
    }

    @PutMapping
    @Transactional
    public void update(@Valid @RequestBody MedicoUpdateForm medicoUpdateForm) {
        medicoService.update(medicoUpdateForm);
    }
}
