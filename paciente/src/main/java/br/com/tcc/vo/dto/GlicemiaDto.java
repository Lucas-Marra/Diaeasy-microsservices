package br.com.tcc.vo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class GlicemiaDto {
    private Long id;
    private Double valor;
    private LocalDate data;
    private String horario;
    private LocalDate dataRefeicao;
    private String horarioRefeicao;
    private String observacao;

    public GlicemiaDto(Glicemia glicemia) {
        this.id = glicemia.getId();
        this.valor = Double.parseDouble(glicemia.getValor());
        this.observacao = glicemia.getObservacao();
        this.data = glicemia.getHorario().toLocalDate();
        this.horario = glicemia.getHorario().toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm"));
        this.dataRefeicao = glicemia.getHorarioRefeicao().toLocalDate();
        this.horarioRefeicao = glicemia.getHorarioRefeicao().toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm"));
    }
}
