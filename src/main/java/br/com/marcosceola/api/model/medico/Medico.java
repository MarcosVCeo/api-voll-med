package br.com.marcosceola.api.model.medico;

import br.com.marcosceola.api.dto.medico.MedicoForm;
import br.com.marcosceola.api.dto.medico.MedicoUpdateForm;
import br.com.marcosceola.api.model.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "medico")
@Table(name = "medicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Medico(MedicoForm medicoForm) {
        this.nome = medicoForm.nome();
        this.email = medicoForm.email();
        this.telefone = medicoForm.telefone();
        this.crm = medicoForm.crm();
        this.especialidade = medicoForm.especialidade();
        this.endereco = new Endereco(medicoForm.endereco());
        this.ativo = true;
    }

    public void desativar() {
        this.ativo = false;
    }

    public void atualizarInformacoes(MedicoUpdateForm medicoUpdateForm) {

        if (medicoUpdateForm.nome() != null) {
            this.nome = medicoUpdateForm.nome();
        }

        if (medicoUpdateForm.telefone() != null) {
            this.telefone = medicoUpdateForm.telefone();
        }

        if (medicoUpdateForm.endereco() != null) {
            this.endereco.atualizarInformacoes(medicoUpdateForm.endereco());
        }
    }
}
