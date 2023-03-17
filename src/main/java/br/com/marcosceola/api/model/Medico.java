package br.com.marcosceola.api.model;

import br.com.marcosceola.api.dto.MedicoForm;
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

    public Medico(MedicoForm medicoForm) {
        this.nome = medicoForm.nome();
        this.email = medicoForm.email();
        this.telefone = medicoForm.telefone();
        this.crm = medicoForm.crm();
        this.especialidade = medicoForm.especialidade();
        this.endereco = new Endereco(medicoForm.endereco());
    }
}
