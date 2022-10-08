package br.com.tcc.vo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GlicemiaDto {
    private Long id;
    //TODO encriptar valor
    private Double valor;
    private String data;
    private String hora;
    private String dataRefeicao;
    private String horaRefeicao;
    private String observacao;
}
