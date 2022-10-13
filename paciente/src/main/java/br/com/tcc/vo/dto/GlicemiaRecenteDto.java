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
        this.setValor(glicemia.getValor());
        this.setDia(glicemia.getHorario().toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        this.setHora(glicemia.getHorario().toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm")));
    }
}
