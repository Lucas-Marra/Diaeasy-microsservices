package br.com.tcc.vo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class GlicemiaRecenteDto {
    private Double valor;
    private String dia;
    private String hora;

    public GlicemiaRecenteDto(Glicemia glicemia) {
        this.valor = Double.parseDouble(glicemia.getValor());
        this.dia = glicemia.getHorario().toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.hora = glicemia.getHorario().toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm"));
    }
}
