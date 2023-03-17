package br.com.marcosceola.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EnderecoForm(
        @NotBlank
        String logradouro,

        String numero,

        String complemento,

        @NotBlank
        String bairro,

        @NotBlank
        String cidade,

        @NotBlank
        @Pattern(regexp = "[a-zA-Z]{2}")
        String uf,

        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep) {
}
