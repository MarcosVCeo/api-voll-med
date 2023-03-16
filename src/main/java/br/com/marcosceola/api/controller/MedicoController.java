package br.com.marcosceola.api.controller;

import br.com.marcosceola.api.dto.MedicoForm;
import br.com.marcosceola.api.model.Endereco;
import br.com.marcosceola.api.model.Medico;
import br.com.marcosceola.api.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public void cadastrar(@RequestBody MedicoForm medicoForm) {
        medicoService.save(medicoForm2Medico(medicoForm));
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

        return new Medico(
                null,
                medicoForm.nome(),
                medicoForm.email(),
                medicoForm.crm(),
                medicoForm.especialidade(),
                endereco);
    }
}
