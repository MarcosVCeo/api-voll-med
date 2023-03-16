package br.com.marcosceola.api.dto;

public record EnderecoForm(
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String uf,
        String cep) {
}
