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
    private LocalDate dia;
    private String hora;
    private LocalDate diaRefeicao;
    private String horaRefeicao;
    private String observacao;

    public GlicemiaDto(Glicemia glicemia) {
        this.id = glicemia.getId();
        this.valor = glicemia.getValor();
        this.observacao = glicemia.getObservacao();
        this.dia = glicemia.getHorario().toLocalDate();
        this.hora = glicemia.getHorario().toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm"));
        this.diaRefeicao = glicemia.getHorarioRefeicao().toLocalDate();
        this.horaRefeicao = glicemia.getHorarioRefeicao().toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm"));
    }
}
