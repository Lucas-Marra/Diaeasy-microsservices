package br.com.tcc.vo.form;

import br.com.tcc.model.Paciente;
import br.com.tcc.model.RegistroGlicemia;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GlicemiaForm {
    private Double valor;
    private LocalDate data;
    private LocalTime horario;
    private LocalDate dataRefeicao;
    private LocalTime horarioRefeicao;
    private String observacao;

    public RegistroGlicemia converter(Paciente paciente) {
        return RegistroGlicemia.builder().
            valor(String.valueOf(this.valor)).
            horario(LocalDateTime.of(this.data, this.horario)).
            horarioRefeicao(LocalDateTime.of(this.dataRefeicao, this.horarioRefeicao)).
            observacao(this.observacao).
            paciente(paciente).build();
    }
}
