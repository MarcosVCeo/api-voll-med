package br.com.marcosceola.api.model;

import br.com.marcosceola.api.dto.EnderecoForm;
import br.com.marcosceola.api.dto.EnderecoUpdateForm;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;

    public Endereco(EnderecoForm enderecoForm) {
        this.logradouro = enderecoForm.logradouro();
        this.numero = enderecoForm.numero();
        this.complemento = enderecoForm.complemento();
        this.bairro = enderecoForm.bairro();
        this.cidade = enderecoForm.cidade();
        this.uf = enderecoForm.uf();
        this.cep = enderecoForm.cep();
    }

    public void atualizarInformacoes(EnderecoUpdateForm enderecoUpdateForm) {
        if (enderecoUpdateForm.logradouro() != null) {
            this.logradouro = enderecoUpdateForm.logradouro();
        }

        if (enderecoUpdateForm.numero() != null) {
            this.numero = enderecoUpdateForm.numero();
        }

        if (enderecoUpdateForm.complemento() != null) {
            this.complemento = enderecoUpdateForm.complemento();
        }

        if (enderecoUpdateForm.bairro() != null) {
            this.bairro = enderecoUpdateForm.bairro();
        }

        if (enderecoUpdateForm.cidade() != null) {
            this.cidade = enderecoUpdateForm.cidade();
        }

        if (enderecoUpdateForm.uf() != null) {
            this.uf = enderecoUpdateForm.uf();
        }

        if (enderecoUpdateForm.cep() != null) {
            this.cep = enderecoUpdateForm.cep();
        }
    }
}
