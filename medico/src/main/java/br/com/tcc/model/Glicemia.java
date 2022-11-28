package br.com.tcc.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Glicemia {
    private Long id;
    private Double valor;
    private LocalDate dia;
    private String hora;
    private LocalDate diaRefeicao;
    private String horaRefeicao;
    private String observacao;
}
