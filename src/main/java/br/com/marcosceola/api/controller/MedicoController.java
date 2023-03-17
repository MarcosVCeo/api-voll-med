package br.com.marcosceola.api.controller;

import br.com.marcosceola.api.dto.EnderecoForm;
import br.com.marcosceola.api.dto.MedicoForm;
import br.com.marcosceola.api.model.Endereco;
import br.com.marcosceola.api.model.Medico;
import br.com.marcosceola.api.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    @Transactional
    public void cadastrar(@Valid @RequestBody MedicoForm medicoForm) {
        medicoService.save(medicoForm2Medico(medicoForm));
    }

    @GetMapping
    public ResponseEntity<List<MedicoForm>> listar() {
        var medicosForm = medicoService
                .listAll()
                .stream()
                .map(MedicoController::medico2MedicoForm)
                .toList();

        return ResponseEntity.ok(medicosForm);
    }

    private static Medico medicoForm2Medico(MedicoForm medicoForm) {
        var enderecoForm = medicoForm.endereco();
        var endereco = new Endereco(
                enderecoForm.logradouro(),
                enderecoForm.numero(),
                enderecoForm.complemento(),
                enderecoForm.bairro(),
                enderecoForm.cidade(),
                enderecoForm.uf(),
                enderecoForm.cep());

        var medico = new Medico(
                null,
                medicoForm.nome(),
                medicoForm.email(),
                medicoForm.telefone(),
                medicoForm.crm(),
                medicoForm.especialidade(),
                endereco);

        return medico;
    }

    private static MedicoForm medico2MedicoForm(Medico medico) {
        var endereco = medico.getEndereco();
        var enderecoForm = new EnderecoForm(
                endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getComplemento(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getUf(),
                endereco.getCep());

        var medicoForm = new MedicoForm(
                medico.getNome(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getTelefone(),
                medico.getEspecialidade(),
                enderecoForm);

        return medicoForm;
    }
}
