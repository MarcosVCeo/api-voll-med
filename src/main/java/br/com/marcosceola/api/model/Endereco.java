package br.com.marcosceola.api.model;

import br.com.marcosceola.api.dto.EnderecoForm;
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
}
