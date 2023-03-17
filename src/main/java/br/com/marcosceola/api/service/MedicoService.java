package br.com.marcosceola.api.service;

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
}
