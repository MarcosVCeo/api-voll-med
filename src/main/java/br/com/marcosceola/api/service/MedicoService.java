package br.com.marcosceola.api.service;

import br.com.marcosceola.api.dto.EnderecoUpdateForm;
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

        if (medicoUpdateForm.nome() != null) {
            medico.setNome(medicoUpdateForm.nome());
        }

        if (medicoUpdateForm.telefone() != null) {
            medico.setTelefone(medico.getTelefone());
        }

        if (medicoUpdateForm.endereco() != null) {
            atualizarEndereco(medico.getEndereco(), medicoUpdateForm.endereco());
        }
    }

    private void atualizarEndereco(Endereco endereco, EnderecoUpdateForm enderecoUpdateForm) {
        if (enderecoUpdateForm.logradouro() != null) {
            endereco.setLogradouro(enderecoUpdateForm.logradouro());
        }

        if (enderecoUpdateForm.numero() != null) {
            endereco.setNumero(enderecoUpdateForm.numero());
        }

        if (enderecoUpdateForm.complemento() != null) {
            endereco.setComplemento(enderecoUpdateForm.complemento());
        }

        if (enderecoUpdateForm.bairro() != null) {
            endereco.setBairro(enderecoUpdateForm.bairro());
        }

        if (enderecoUpdateForm.cidade() != null) {
            endereco.setCidade(enderecoUpdateForm.cidade());
        }

        if (enderecoUpdateForm.uf() != null) {
            endereco.setUf(enderecoUpdateForm.uf());
        }

        if (enderecoUpdateForm.cep() != null) {
            endereco.setCep(enderecoUpdateForm.cep());
        }
    }
}
