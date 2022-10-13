package br.com.tcc.vo.dto;

import br.com.tcc.model.RegistroGlicemia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Glicemia {
    private Long id;
    private Double valor;
    private LocalDateTime horario;
    private LocalDateTime horarioRefeicao;
    private String observacao;

    public Glicemia(RegistroGlicemia registroGlicemia) {
        this.setId(registroGlicemia.getId());
        this.setValor(registroGlicemia.getValor());
        this.setHorario(registroGlicemia.getHorario());
        this.setHorarioRefeicao(registroGlicemia.getHorarioRefeicao());
        this.setObservacao(registroGlicemia.getObservacao());
    }
}
