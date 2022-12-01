package br.com.tcc.vo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class DadosLogin {
    private String token;
    private Long id;
    private String nome;
    private String medicoResponsavel;
    private String tipo;
}
