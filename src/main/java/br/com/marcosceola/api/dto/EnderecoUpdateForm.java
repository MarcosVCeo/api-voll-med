package br.com.marcosceola.api.dto;

public record EnderecoUpdateForm(
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String uf,
        String cep) {
}
