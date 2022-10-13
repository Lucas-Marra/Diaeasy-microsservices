package br.com.tcc.vo.form;

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
public class AlterarGlicemiaForm {
    private Long id;
    private Double valor;
    private LocalDate data;
    private LocalTime horario;
    private LocalDate dataRefeicao;
    private LocalTime horarioRefeicao;
    private String observacao;

    public RegistroGlicemia update(RegistroGlicemia registroGlicemia) {
        registroGlicemia.setValor(this.valor);
        registroGlicemia.setHorario(LocalDateTime.of(this.data, this.horario));
        registroGlicemia.setHorarioRefeicao(LocalDateTime.of(this.dataRefeicao, this.horarioRefeicao));
        registroGlicemia.setObservacao(this.observacao);
        return registroGlicemia;
    }
}
