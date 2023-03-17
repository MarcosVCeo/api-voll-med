package br.com.marcosceola.api.service;

import br.com.marcosceola.api.dto.MedicoUpdateForm;
import br.com.marcosceola.api.exception.ApiException;
import br.com.marcosceola.api.model.Endereco;
import br.com.marcosceola.api.model.Medico;
import br.com.marcosceola.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

    public void save(Medico medico) {
        repository.save(medico);
    }

    public Page<Medico> listAll(Pageable paginacao) {
        return repository.findAll(paginacao);
    }

    public Medico find(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ApiException(String.format("Não foi possível encontrar um médico com id:'%d'.", id)));
    }

    public void delete(Long id) {
        var medico = this.find(id);
        repository.delete(medico);
    }

    public void update(MedicoUpdateForm medicoUpdateForm) {
        var medico = this.find(medicoUpdateForm.id());

        medico.setNome(medicoUpdateForm.nome());
        medico.setTelefone(medico.getTelefone());
        medico.setEndereco(new Endereco(medicoUpdateForm.endereco()));

        repository.save(medico);
    }
}
