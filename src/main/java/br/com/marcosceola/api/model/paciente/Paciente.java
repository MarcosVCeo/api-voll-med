package br.com.marcosceola.api.model.paciente;

import br.com.marcosceola.api.dto.paciente.PacienteForm;
import br.com.marcosceola.api.dto.paciente.PacienteUpdateForm;
import br.com.marcosceola.api.model.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "paciente")
@Table(name = "pacientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private String cpf;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Paciente(PacienteForm pacienteForm) {
        var enderecoForm = pacienteForm.endereco();
        var endereco = new Endereco(
                enderecoForm.logradouro(),
                enderecoForm.numero(),
                enderecoForm.complemento(),
                enderecoForm.bairro(),
                enderecoForm.cidade(),
                enderecoForm.uf(),
                enderecoForm.cep());

        this.nome = pacienteForm.nome();
        this.email = pacienteForm.email();
        this.telefone = pacienteForm.telefone();
        this.cpf = pacienteForm.cpf();
        this.endereco = endereco;
        this.ativo = true;
    }

    public void atualizarInformacoes(PacienteUpdateForm pacienteUpdateForm) {

        if (pacienteUpdateForm.nome() != null) {
            this.nome = pacienteUpdateForm.nome();
        }

        if (pacienteUpdateForm.telefone() != null) {
            this.telefone = pacienteUpdateForm.telefone();
        }

        if (pacienteUpdateForm.endereco() != null) {
            this.endereco.atualizarInformacoes(pacienteUpdateForm.endereco());
        }
    }
}
