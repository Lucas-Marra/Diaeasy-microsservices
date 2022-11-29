package br.com.tcc.vo.dto;

import br.com.tcc.model.RegistroGlicemia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Glicemia {
    private Long id;
    private Double valor;
    private LocalDateTime horario;
    private LocalDateTime horarioRefeicao;
    private String observacao;

    public Glicemia(RegistroGlicemia registroGlicemia) {
        this.id = registroGlicemia.getId();
        this.valor = registroGlicemia.getValor();
        this.horario = registroGlicemia.getHorario();
        this.horarioRefeicao = registroGlicemia.getHorarioRefeicao();
        this.observacao = registroGlicemia.getObservacao();
    }
}
