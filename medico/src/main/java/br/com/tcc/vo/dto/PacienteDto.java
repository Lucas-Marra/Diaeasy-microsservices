package br.com.tcc.vo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PacienteDto {
    private Long id;
    private String nome;
    private String sexo;
    private LocalDate dataNascimento;
}
