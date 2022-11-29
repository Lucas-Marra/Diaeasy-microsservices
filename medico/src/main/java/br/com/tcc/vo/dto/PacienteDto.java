package br.com.tcc.vo.dto;

import br.com.tcc.model.Paciente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDto {
    private Long id;
    private String nome;
    private String email;
    private String sexo;
    private LocalDate dataNascimento;

    public PacienteDto(Paciente paciente) {
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.email = paciente.getEmail();
        this.sexo = paciente.getSexo();
        this.dataNascimento = paciente.getDataNascimento();
    }

    public Paciente update(Paciente paciente) {
        paciente.setNome(this.nome);
        paciente.setEmail(this.email);
        paciente.setSexo(this.sexo);
        paciente.setDataNascimento(this.dataNascimento);

        return paciente;
    }
}
